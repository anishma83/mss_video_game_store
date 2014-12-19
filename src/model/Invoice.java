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
	private List<Product> products;
	
	/**
	 * Creates new Invoice from the specified Customer, Order, and OrderDetails.
	 *  
	 * @param customer - Customer this invoice is for 
	 * @param order - Order the invoice is created for
	 * @param orderDetails - A list of all the order details that coincide with the order
	 */
	public Invoice(Customer customer, Order order, List<OrderDetail> orderDetails, List<Product> products)
	{
		this.customer = customer;
		this.order = order;
		this.orderDetails = orderDetails;
		this.products = products;
		
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
