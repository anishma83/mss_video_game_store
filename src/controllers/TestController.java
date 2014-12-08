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
import com.mss.store.videogame.dao.OrderDao;
import com.mss.store.videogame.dao.OrderDetailDao;
import com.mss.store.videogame.dao.ProductDao;
import com.mss.store.videogame.dao.ShipperDao;
import com.mss.store.videogame.dao.SupplierDao;
import com.mss.store.videogame.model.Category;
import com.mss.store.videogame.model.Customer;
import com.mss.store.videogame.model.Order;
import com.mss.store.videogame.model.OrderDetail;
import com.mss.store.videogame.model.Product;
import com.mss.store.videogame.model.Shipper;
import com.mss.store.videogame.model.Supplier;



@Controller
public class TestController {
	
	

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
		
		List<Order> orders = orderDao.list();
		model.addObject("orders", orders);
		
		List<OrderDetail> orderDetails = orderDetailDao.list();
		model.addObject("orderDetails", orderDetails);
		
		List<Product> products = productDao.list();
		model.addObject("products", products);
		
		List<Shipper> shippers	= shipperDao.list();
		model.addObject("shippers", shippers);
		
		List<Supplier> suppliers	= supplierDao.list();
		model.addObject("suppliers", suppliers);
		
		return model;
	}
	
	
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

}
