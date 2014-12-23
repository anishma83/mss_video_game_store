package com.mss.store.videogame.model;

import java.sql.Date;


import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Table(name="OrderDetails")
@Entity
public class OrderDetail 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OrderDetailId")	private int 	order_Detail_Id;
	@Column(name="OrderId")			private int		order_Id;
	@Column(name="ProductId")		private int		product_Id;
	@Column(name="Price")			private double	price;
	@Column(name="Quantity")		private int		quantity;
	@Column(name="Total")			private double	total;
	@Column(name="Fulfilled")		private boolean	fulfilled;
	@Column(name="BillDate")		private Date	bill_Date;
	@Column(name="ShipDate")		private Date	ship_Date;
	@Column(name="ShipperId")		private int		shipper_Id;
	@Column(name="Freight")			private double	freight;
	@Column(name="SalesTax")		private double 	sales_Tax;
	
	@ManyToOne( fetch=FetchType.EAGER, targetEntity=Product.class)
	@JoinColumn(name="productId")
	private Product product;
	
	
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


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
