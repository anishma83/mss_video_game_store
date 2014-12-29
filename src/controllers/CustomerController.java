package com.mss.store.videogame.web.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mss.store.videogame.dao.CustomerDao;
import com.mss.store.videogame.dao.OrderDao;
import com.mss.store.videogame.dao.OrderDetailDao;
import com.mss.store.videogame.dao.ProductDao;
import com.mss.store.videogame.dao.SupplierDao;
import com.mss.store.videogame.model.Customer;
import com.mss.store.videogame.model.Order;
import com.mss.store.videogame.model.OrderDetail;
import com.mss.store.videogame.model.Product;
import com.mss.store.videogame.model.Supplier;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	Customer customer;

	@Autowired
	OrderDao orderDao;

	@Autowired
	OrderDetailDao orderDetailDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	SupplierDao supplierDao;

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public ModelAndView signInPage() {
		ModelAndView model = new ModelAndView("Template");
		Customer customer = new Customer();
		model.addObject("mainpage", "login.jsp");
		model.addObject("customer", this.customer);
		return model;
	}

	@RequestMapping(value = "/signInCheck", method = RequestMethod.GET)
	public ModelAndView SignIn(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult result) {

		ModelAndView model = new ModelAndView("Template");
		Customer customerSignInCheck = customerDao
				.signedIn(customer.getEmail());
		String mainPage = "";

		if (customerSignInCheck.getPassword().equals(customer.getPassword())) {
			this.customer.setIs_Logged_In(true);
			customerSignInCheck.setIs_Logged_In(true);
			this.customer = customerSignInCheck;
			model.setViewName("redirect:/products");
		} else {
			mainPage = "login.jsp";
			model.addObject("Login_Info", "Username or Password not found");
			this.customer.setIs_Logged_In(false);
		}
		model.addObject("mainpage", mainPage);
		model.addObject("customer", this.customer);
		return model;

	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUpPage() {
		ModelAndView model = new ModelAndView("Template");
		model.addObject("signUpPage", "signUp");
		model.addObject("customer", this.customer);
		model.addObject("mainpage", "signUp.jsp");

		return model;
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.GET)
	public ModelAndView saveCustomer(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult result) throws ParseException {
		ModelAndView model = new ModelAndView("Template");
		long time = System.currentTimeMillis();
		java.sql.Date currentDate = new java.sql.Date(time);
		if (customer.getDate_Entered() == null) {
			customer.setDate_Entered(currentDate);
		} else {
			currentDate = customer.getDate_Entered();
		}
		customer.setMember("t");
		customerDao.save(customer);
		this.customer = customer;
		model.addObject("mainpage", "memberProfile.jsp");
		return model;
	}

	@RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
	public ModelAndView viewProfile() {
		ModelAndView model = new ModelAndView("Template");
		List<Order> order = customer.getOrders();
		for (Order o : order) {
			for (OrderDetail od : o.getOrderDetails()) {

			}
		}

		model.addObject("order", order);
		model.addObject("customer", this.customer);
		model.addObject("mainpage", "memberProfile.jsp");
		return model;
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
	public ModelAndView updateProfile() {
		ModelAndView model = new ModelAndView("Template");
		model.addObject("customer", this.customer);
		model.addObject("updateProfilePage", "updateProfile");
		model.addObject("mainpage", "updateProfile.jsp");
		return model;
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
	public ModelAndView updateCustomer(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult result) {
		ModelAndView model = new ModelAndView("Template");
		long time = System.currentTimeMillis();
		java.sql.Date currentDate = new java.sql.Date(time);
		customer.setDate_Entered(currentDate);
		customer.setMember("t");
		this.customer = customer;
		customerDao.updateCustomer(this.customer);
		model.addObject("mainpage", "memberProfile.jsp");
		model.addObject("customer", this.customer);
		System.out.println(this.customer.isIs_Logged_In());
		return model;
	}
	
	@RequestMapping(value = "/viewOrderDetails", method = RequestMethod.GET)
	public ModelAndView viewOrderDetails(@RequestParam int id) {
		ModelAndView model = new ModelAndView("Template");
		List<Order> order = orderDao.lookupById(id);
		model.addObject("order", order);
		model.addObject("mainpage", "orderDetails.jsp");
		return model;
	}

}
