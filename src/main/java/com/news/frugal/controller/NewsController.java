package com.news.frugal.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.news.frugal.model.News;
import com.news.frugal.news.importer.ODSImporter;

@Controller
public class NewsController {
	@Autowired
	private ODSImporter odsImporter;  
	
	@RequestMapping(value = "/api/news", method = RequestMethod.GET)
	@ResponseBody
	public List<News> getTodaysNews(){
		return odsImporter.importNews(new File("news.ods"));
	}
}
