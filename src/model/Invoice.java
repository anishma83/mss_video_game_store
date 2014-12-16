package com.mss.store.videogame.model;

import java.util.List;

/**
 * 
 * @author Anton Franklin
 *
 */
public class Invoice {
	
	private Customer customer;
	private Order order;
	private List<OrderDetail> orderDetails;
	
	/**
	 * Creates new Invoice from the specified Customer, Order, and OrderDetails.
	 *  
	 * @param customer - Customer this invoice is for 
	 * @param order - Order the invoice is created for
	 * @param orderDetails - A list of all the order details that coincide with the order
	 */
	public Invoice(Customer customer, Order order, List<OrderDetail> orderDetails)
	{
		this.customer = customer;
		this.order = order;
		this.orderDetails = orderDetails;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	

}