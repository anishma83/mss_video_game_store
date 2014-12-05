package com.mss.store.videogame.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mss.store.videogame.dao.CategoryDao;
import com.mss.store.videogame.dao.CustomerDao;
import com.mss.store.videogame.model.Category;
import com.mss.store.videogame.model.Customer;



@Controller
public class TestController {
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/hello")
	protected ModelAndView helloWorldTest(HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{
		ModelAndView model = new ModelAndView("Test");
		model.addObject("hello", "Hello World Test");
		
		List<Category> categories = categoryDao.list();
		model.addObject("categories", categories);
		
		List<Customer> customers = customerDao.list();
		model.addObject("customers", customers);
		return model;
	}

}
