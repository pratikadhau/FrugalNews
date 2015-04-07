package com.news.frugal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


	@RequestMapping("/home")
	public String loadHomePage(Model model) {
		return "home";
	}

	
}
