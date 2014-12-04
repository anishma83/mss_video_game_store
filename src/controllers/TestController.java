package com.mss.store.videogame.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class TestController {
	
	@RequestMapping("/hello")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{
		ModelAndView model = new ModelAndView("Test.jsp");
		model.addObject("hello", "Hello World Test");
		return model;
	}

}