package com.news.frugal.controller;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.news.frugal.commom.pojo.NewsServiceResponse;
import com.news.frugal.common.util.CommonUtil;
import com.news.frugal.dao.entity.News;
import com.news.frugal.news.importer.ODSImporter;

@Controller
@RequestMapping("/news")
public class NewNewsController {
	private final CommonUtil commonUtil = new CommonUtil();

	@Autowired
	private ODSImporter odsImporter;
	private List<News> newsList;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> getTodaysNews() {
		NewsServiceResponse<List<News>> newsServiceResponse = new NewsServiceResponse<List<News>>();

		if (newsList != null) {
			newsServiceResponse.setResponse(newsList);

			String responseJson = commonUtil.writeResponseAsString(newsServiceResponse);
			return new ResponseEntity<String>(responseJson, new HttpHeaders(), HttpStatus.OK);
		}

		newsList = odsImporter.importNews(new File("news.ods"));
		Integer index = 0;

		for (News news : newsList) {
			news.setNewsId(++index);
		}

		newsServiceResponse.setResponse(newsList);

		String responseJson = commonUtil.writeResponseAsString(newsServiceResponse);
		return new ResponseEntity<String>(responseJson, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{newsId}", method = RequestMethod.GET)
	public ResponseEntity<String> get(@PathVariable final Integer newsId) {

		News idBasedNewsObject;
		Stream<News> filter = newsList.stream().filter(new Predicate<News>() {
			@Override
			public boolean test(News temp) {
				return temp.getNewsId().equals(newsId);
			}
		});

		idBasedNewsObject = filter.findFirst().get();

		NewsServiceResponse<News> newsServiceResponse = new NewsServiceResponse<News>();
		if (null == idBasedNewsObject) {
			newsServiceResponse.setErrorCode("FNBE_1000");
			newsServiceResponse.setErrorMessage("No perticular news available for given newsId.");

			String responseJson = commonUtil.writeResponseAsString(newsServiceResponse);
			return new ResponseEntity<String>(responseJson, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}

		newsServiceResponse.setResponse(idBasedNewsObject);
		String responseJson = commonUtil.writeResponseAsString(newsServiceResponse);

		return new ResponseEntity<String>(responseJson, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/types", method = RequestMethod.GET)
	public ResponseEntity<String> getNewsTypes() {
		NewsServiceResponse<Set<String>> newsServiceResponse = new NewsServiceResponse<Set<String>>();

		Set<String> newsTypes = new HashSet<String>();
		newsTypes.add("Headline");
		newsTypes.add("Business");
		newsTypes.add("Politics");
		newsTypes.add("Foreign");
		newsTypes.add("Sports");

		newsServiceResponse.setResponse(newsTypes);
		String responseJson = commonUtil.writeResponseAsString(newsServiceResponse);

		return new ResponseEntity<String>(responseJson, new HttpHeaders(), HttpStatus.OK);
	}
}