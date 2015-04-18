package com.news.frugal.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.news.frugal.dao.entity.News;
import com.news.frugal.news.importer.ODSImporter;

@Controller
public class IndexController {
	@Autowired
	private ODSImporter odsImporter;
	
	@Autowired 
	private NewsController newsController;

	@RequestMapping("/")
	public String loadHomePage(Model model) {
		model.addAttribute("appUrl", "http://freenews-coherent.rhcloud.com/FrugalNews");
		return "home";
	}

	@RequestMapping("/upload")
	public String openUpload(Model model) {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				File convFile = new File("news.ods");
		        file.transferTo(convFile);
		        List<News> newsList = odsImporter.importNews(convFile);
		        Integer index = 0;
		        for (News news : newsList) {
		        	news.setNewsId(++index);
				}
		        newsController.setNews(newsList);
				return newsList.size() +" news are published";
			} catch (Exception e) {
				return "News are failed to be published ";
			}
		} else {
			return "You failed to upload  because the file was empty.";
		}
	}

}
