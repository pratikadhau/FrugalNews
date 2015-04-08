package com.news.frugal.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.news.frugal.model.News;

@Controller
public class NewsController {
	
	@RequestMapping(value = "/api/news", method = RequestMethod.GET)
	@ResponseBody
	public List<News> getTodaysNews(){
		News news = new News();
		news.setDisplayDate(new Date());
		news.setReportDate(new Date());
		news.setNewsType("Headline");
		news.setHeadline("Row over govt's plan to build 'composite townships' for Kashmiri pandits");
		news.setNewsDetail("NEW DELHI: Prime Minister Narendra Modi aims to advance the purchase of massive nuclear reactors and fuel from France and Canada to power a resurgent economy, overriding domestic opposition and concerns over liability laws as he embarks on a foreign tour. In France, where Modi is making his first visit since taking office last year, he will seek to speed up price negotiations for the building of two reactors by state-run Areva SA of 1,650 megawatts each in the western state of Maharashtra.");
		news.setReporterEmailId("pratikadhau1@gmail.com");
		News news1 = new News();
		news1.setDisplayDate(new Date());
		news1.setReportDate(new Date());
		news1.setNewsType("Headline");
		news1.setHeadline("Google Ventures-backed Buttercoin shutting down on April 10");
		news1.setNewsDetail("WASHINGTON: Google Ventures and Y Combinator backed bitcoin exchange startup Buttercoin, is shutting down this month after failing to raise new investment. According to the TechCrunch, Buttercoin said in a note on its website that they will be turning off their service on April 10 and asked its users to move their bitcoins to another service and remove their dollar balances by April 10. Buttercoin also said that any unclaimed funds will be returned to the accounts that they came from.");
		news1.setReporterEmailId("chakotetushar@gmail.com");
		return Arrays.asList(news,news1);
	}
}
