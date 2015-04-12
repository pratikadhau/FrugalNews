package com.news.frugal.controller;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.news.frugal.model.News;
import com.news.frugal.news.importer.ODSImporter;

@Controller
public class NewsController {
	@Autowired
	private ODSImporter odsImporter;

	private List<News> newsList;

	@RequestMapping(value = "/api/news", method = RequestMethod.GET)
	@ResponseBody
	public List<News> getTodaysNews() {
		if (newsList != null)
			return newsList;

		newsList = odsImporter.importNews(new File("news.ods"));
		Integer index = 0;

		for (News news : newsList) {
			news.setNewsId(++index);
		}

		return newsList;
	}

	@RequestMapping(value = "/api/news/{newsId}", method = RequestMethod.GET)
	@ResponseBody
	public News getNews(@PathVariable final Integer newsId) {
		Stream<News> filter = newsList.stream().filter(new Predicate<News>() {
			@Override
			public boolean test(News temp) {
				return temp.getNewsId().equals(newsId);
			}
		});

		return filter.findFirst().get();
	}
}
