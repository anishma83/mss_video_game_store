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
		ModelAndView model=new ModelAndView("Template");
		Customer customer = new Customer();
		model.addObject("mainpage", "login.jsp");
		model.addObject("customer", customer);
		return model;
	}
	
	@RequestMapping(value="/signInCheck",method = RequestMethod.GET)
	public ModelAndView SignIn(@Valid @ModelAttribute("customer") Customer customer, BindingResult result)
	{
		
		ModelAndView model = new ModelAndView("Template");
		Customer customerSignInCheck = customerDao.signedIn(customer.getEmail());
		String mainPage ="";
		
		if(customerSignInCheck.getPassword().equals(customer.getPassword())){
		
			this.customer.setIs_Logged_In(true);
			this.customer=customerSignInCheck;
			System.out.println("the information that came back from dao is: "+this.customer.getAddress_1());
			model.setViewName("redirect:/products");
		}
		else {
			mainPage="login.jsp";
			model.addObject("Login_Info", "Username or Password not found");
			this.customer.setIs_Logged_In(false);
		}
		model.addObject("mainpage", mainPage);
		return model;
		 
	}


	@RequestMapping(value="/signUp",method= RequestMethod.GET)
	public ModelAndView signUpPage() {
		ModelAndView model = new ModelAndView("Template");
		model.addObject("signUpPage", "signUp");
		model.addObject("customer", customer);
		model.addObject("mainpage","signUp.jsp");
		return model;		
	}
	
		
	@RequestMapping(value="/saveCustomer", method= RequestMethod.GET)
	public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) throws ParseException {
		ModelAndView model = new ModelAndView("Template");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date currentDate = new java.util.Date();
		String cDate=sdf.format(currentDate);
		customer.setDate_Entered(Date.valueOf(cDate));
		customer.setMember("t");
		System.out.println("The record values are: "+customer.toString());
		customerDao.save(customer);	
		this.customer = customer;
		model.addObject("mainpage", "viewProfile.jsp");
		return model;
	}
	
	@RequestMapping(value="/viewProfile", method= RequestMethod.GET)
	public ModelAndView viewProfile() {
		ModelAndView model = new ModelAndView("Template");
		model.addObject("customer", customer);
		model.addObject("profilePage", "viewProfile");
		model.addObject("mainpage", "memberProfile.jsp");
	return model;
	}
	
	@RequestMapping(value="/updateProfile", method= RequestMethod.GET)
	public ModelAndView updateProfile() {
		ModelAndView model = new ModelAndView("Template");
		model.addObject("customer", customer);
		model.addObject("updateProfilePage", "updateProfile");
		model.addObject("mainpage", "updateProfile.jsp");
		return model;
	}
}

