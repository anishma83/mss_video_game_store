package com.mss.store.videogame.web.controllers;



import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.mss.store.videogame.dao.CustomerDao;
import com.mss.store.videogame.dao.OrderDao;
import com.mss.store.videogame.model.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao; 
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	Customer customer;
	
	@RequestMapping(value="/signIn",method = RequestMethod.GET)
	public ModelAndView signInPage(){
		ModelAndView model=new ModelAndView("login");
		Customer customer = new Customer();
		model.addObject("mainpage", "login");
		model.addObject("customer", customer);
		return model;
	}
	
	@RequestMapping(value="/signInCheck",method = RequestMethod.GET)
	public ModelAndView SignIn(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, HttpSession session)
	{
		
		ModelAndView model = new ModelAndView();
		Customer customerSignInCheck = customerDao.signedIn(customer.getEmail());
		
		if(customerSignInCheck.getPassword().equals(customer.getPassword())){
			session.setAttribute("is_Logged_In", true);
			this.customer=customerSignInCheck;
			System.out.println("the information that came back from dao is: "+this.customer.getAddress_1());
			model.setViewName("product");
		}
		else {
			model.setViewName("login");
			model.addObject("Login_Info", "Username or Password not found");
			session.setAttribute("is_Logged_In", false);
		}
		
		System.out.println(session.getAttribute("is_Logged_In").toString());
		return model;
		 
	}


	@RequestMapping(value="/signUp",method= RequestMethod.GET)
	public ModelAndView signUpPage() {
		ModelAndView model = new ModelAndView("signUp");
		model.addObject("signUpPage", "signUp");
		model.addObject("customer", customer);
		return model;		
	}
	
		
	@RequestMapping(value="/saveCustomer", method= RequestMethod.GET)
	public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, HttpSession session) throws ParseException {
		ModelAndView model = new ModelAndView("viewProfile");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date currentDate = new java.util.Date();
		String cDate=sdf.format(currentDate);
		customer.setDate_Entered(Date.valueOf(cDate));
		customer.setMember("t");
		System.out.println("The record values are: "+customer.toString());
		customerDao.save(customer);	
		this.customer = customer;
		return model;
	}
	
	@RequestMapping(value="/viewProfile", method= RequestMethod.GET)
	public ModelAndView viewProfile(HttpSession session ) {
		ModelAndView model = new ModelAndView("memberProfile");
		model.addObject("customer", customer);
		System.out.println(customer.getAddress_1());
		model.addObject("profilePage", "viewProfile");
	return model;
	}
}

