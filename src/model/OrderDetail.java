package com.mss.store.videogame.model;

import java.sql.Date;

public class OrderDetail 
{
	private int 	order_Detail_Id;
	private int		order_Id;
	private int		product_Id;
	private double	price;
	private int		quantity;
	private double	total;
	private boolean	fulfilled;
	private Date	bill_Date;
	private Date	ship_Date;
	private int		shipper_Id;
	private double	freight;
	private double sales_Tax;
	
	
	public OrderDetail()
	{
		
	}


	public int getOrder_Detail_Id() {
		return order_Detail_Id;
	}


	public void setOrder_Detail_Id(int order_Detail_Id) {
		this.order_Detail_Id = order_Detail_Id;
	}


	public int getOrder_Id() {
		return order_Id;
	}


	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}


	public int getProduct_Id() {
		return product_Id;
	}


	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public boolean isFulfilled() {
		return fulfilled;
	}


	public void setFulfilled(boolean fulfilled) {
		this.fulfilled = fulfilled;
	}


	public Date getBill_Date() {
		return bill_Date;
	}


	public void setBill_Date(Date bill_Date) {
		this.bill_Date = bill_Date;
	}


	public Date getShip_Date() {
		return ship_Date;
	}


	public void setShip_Date(Date ship_Date) {
		this.ship_Date = ship_Date;
	}


	public int getShipper_Id() {
		return shipper_Id;
	}


	public void setShipper_Id(int shipper_Id) {
		this.shipper_Id = shipper_Id;
	}


	public double getFreight() {
		return freight;
	}


	public void setFreight(double freight) {
		this.freight = freight;
	}


	public double getSales_Tax() {
		return sales_Tax;
	}


	public void setSales_Tax(double sales_Tax) {
		this.sales_Tax = sales_Tax;
	}
	
	

}
