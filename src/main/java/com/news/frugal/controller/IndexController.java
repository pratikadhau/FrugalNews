package com.news.frugal.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.news.frugal.dao.entity.News;
import com.news.frugal.news.importer.NewsImporterFactory;

@Controller
public class IndexController {
	@Autowired
	private NewsImporterFactory  newsImporterFactory;
	
	@Autowired 
	private NewsController newsController;
	
	@Autowired
	private Environment env;

	
	@RequestMapping("/")
	public String loadHomePage(Model model) throws UnsupportedEncodingException  {
		model.addAttribute("appUrl", env.getProperty("baseurl"));
		model.addAttribute("title",new String(env.getProperty("title").getBytes("ISO-8859-1"),"UTF-8"));
		return "home";
	}

	@RequestMapping("/upload")
	public String openUpload(Model model) {
		return "upload";
	}

	@RequestMapping("/api/title")
	@ResponseBody
	public String getTitle(Model model) throws UnsupportedEncodingException {
		return new String(env.getProperty("title").getBytes("ISO-8859-1"),"UTF-8");
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				String originalFilename = file.getOriginalFilename();
				File convFile = new File(originalFilename);
		        file.transferTo(convFile);
		        List<News> newsList = newsImporterFactory.getNewsImporte(getFileFormat(originalFilename)).importNews(convFile);
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

	private String getFileFormat(String originalFilename) {
		return originalFilename.substring(originalFilename.lastIndexOf	(".")+1);
	}
	
	

}
