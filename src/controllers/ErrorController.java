package com.mss.store.videogame.web.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mss.store.videogame.model.Customer;

@Controller
public class ErrorController {
	
	@Autowired
	Customer customer;
	
	@RequestMapping("/404")
	public ModelAndView ErrorPage404()
	{
		ModelAndView model = new ModelAndView("Template");
		model.addObject("customer", this.customer);
		model.addObject("mainpage","404.jsp");
		return model;
	}
}
