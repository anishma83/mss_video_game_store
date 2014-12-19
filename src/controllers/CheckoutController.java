package com.mss.store.videogame.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mss.store.videogame.dao.CategoryDao;
import com.mss.store.videogame.dao.CustomerDao;
import com.mss.store.videogame.dao.OrderDao;
import com.mss.store.videogame.dao.OrderDetailDao;
import com.mss.store.videogame.dao.ProductDao;
import com.mss.store.videogame.dao.ShipperDao;
import com.mss.store.videogame.dao.SupplierDao;
import com.mss.store.videogame.model.Customer;
import com.mss.store.videogame.model.Order;
import com.mss.store.videogame.model.OrderDetail;
import com.mss.store.videogame.model.Product;


@Controller
public class CheckoutController {
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired 
	OrderDao	orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	@Autowired
	ProductDao	productDao;
	@Autowired
	ShipperDao	shipperDao;
	@Autowired
	SupplierDao	supplierDao;
	@Autowired
	Customer customer;
	
	@RequestMapping("/finalCheckout")
	protected ModelAndView createCheckout(HttpServletRequest request,
			HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("Template");
		boolean isLoggedIn = customer.isIs_Logged_In();
		
		if(isLoggedIn)
		{
			 
		}else
		{
			customer = customerDao.lookupById(1).get(0);
		}
		model.addObject("customer", customer);
		
		List<Order> customerOrders =
				orderDao.lookupByCustomerId(customer.getCustomer_Id());
		Order currentOrder =  new Order();
		for(Order o:customerOrders)
		{
			if(!o.isPaid())
			{
				currentOrder=o;
				break;
			}
		}
		
		List<OrderDetail> currentOrderDetails = 
				orderDetailDao.lookupByOrderId(currentOrder.getOrder_Id());
		model.addObject("orderDetails", currentOrderDetails);
		
		double cartTotal =0;
		double shippingCost = 0;
		double salesTax = 0;
		List<Product> products = new ArrayList<Product>();
		
		for(OrderDetail od: currentOrderDetails)
		{
			cartTotal+=od.getPrice();
			salesTax+=od.getSales_Tax();
			shippingCost +=2;
			products.addAll(productDao.lookupById(od.getProduct_Id()));
		}
		model.addObject("mainpage","checkout.jsp");
		model.addObject("shippingCost", shippingCost);
		model.addObject("cartTotal",cartTotal);
		model.addObject("salesTax",salesTax);
		model.addObject("products",products);
		model.addObject("total",cartTotal+salesTax+shippingCost);
		

		return model;
		
	}

}
