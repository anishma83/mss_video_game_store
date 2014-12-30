package com.mss.store.videogame.web.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mss.store.videogame.dao.CustomerDao;
import com.mss.store.videogame.dao.OrderDao;
import com.mss.store.videogame.dao.OrderDetailDao;
import com.mss.store.videogame.dao.ProductDao;
import com.mss.store.videogame.invoice.AutoUpdateDB;
import com.mss.store.videogame.invoice.EmailConfirmation;
import com.mss.store.videogame.invoice.ReorderProduct;
import com.mss.store.videogame.model.Customer;
import com.mss.store.videogame.model.Invoice;
import com.mss.store.videogame.model.Order;
import com.mss.store.videogame.model.OrderDetail;
import com.mss.store.videogame.model.Product;


@Controller
public class InvoiceController {
	
	@Autowired
	CustomerDao customerDao;
	@Autowired 
	OrderDao	orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	@Autowired
	ProductDao	productDao;
	@Autowired
	Customer customer;
	@Autowired
	AutoUpdateDB dbUpdater;
	
	@RequestMapping("/thankYou")
	protected ModelAndView confirm(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView model = new ModelAndView("thankYou");
		boolean isLoggedIn = customer.isIs_Logged_In();
		
		/*
		 * Customer
		 */
		
		if(isLoggedIn)
		{
			 
		}else
		{
			customer = customerDao.lookupById(1);
		}
		model.addObject("customer", customer);
		
		List<Order> customerOrders =
				orderDao.lookupByCustomerId(customer.getCustomer_Id());
		Order currentOrder =  new Order();
		for(Order o:customerOrders)
		{
			if(o.isPaid())
			{
				currentOrder=o;
				break;
			}
		}
		
		List<OrderDetail> currentOrderDetails = 
				orderDetailDao.lookupByOrderId(currentOrder.getOrder_Id());
		model.addObject("orderDetails", currentOrderDetails);
		
		/*
		 * Products
		 */
		List<Product> products = new ArrayList<Product>();
		
		for(OrderDetail od: currentOrderDetails)
		{
			//products.addAll(productDao.lookupById(od.getProduct_Id()));
		}
		
		/*
		 * Invoice Operations
		 */
		Invoice invoice = new Invoice(this.customer, currentOrder, currentOrderDetails, products);
		//EmailConfirmation emailConfirm = new EmailConfirmation(invoice.getOrder(), invoice.getCustomer());
		dbUpdater = new AutoUpdateDB(invoice);
		dbUpdater.run();
		ReorderProduct reorderProduct = new ReorderProduct(invoice);
		
		model.addObject("customer",this.customer);
		return model;
		
	}
	
	/*Admin Login content*/
	
	@RequestMapping("/adminLogin")
	protected ModelAndView loginAdmin(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		ModelAndView model = new ModelAndView("adminLogin");
		//model.addObject("hello", "Hello World Test");
		if(username.equals("admin"))
		{
			if(password.equals("anton"))
			{
				model.setViewName("Template");
			}
			else
			{
				model.setViewName("adminLogin");
				model.addObject("Login_Info", "Username or Password not found");
			}
		}
		else
		{
			model.setViewName("adminLogin");
			model.addObject("Login_Info", "Username or Password not found");
		}

		model.addObject("customer",this.customer);
		return model;
	}
	
	/*@RequestMapping("/login")
	    public void login(@RequestParam("username") String username,
	           @RequestParam("password") String password) {

	        // the UserServiceImpl is already injected and you can use it
	        userService.login(username, password);

	    }*/

}
