package com.mss.store.videogame.model;

import java.sql.Date;

public class Order {
	private int		order_Id;
	private int		customer_Id;
	private Date	order_Date;
	private Date	ship_Date;
	private int		shipper_Id;
	private double	freight;
	private double	sales_Tax;
	private String	order_Timestamp;
	private String	transaction_Status;
	private String	error_Log;
	private String	error_Message;
	private boolean	fulfilled;
	private boolean	deleted;
	private boolean paid;
	private Date	payment_Date;
	
	public Order()
	{
	
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
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

	public String getOrder_Timestamp() {
		return order_Timestamp;
	}

	public void setOrder_Timestamp(String order_Timestamp) {
		this.order_Timestamp = order_Timestamp;
	}

	public String getTransaction_Status() {
		return transaction_Status;
	}

	public void setTransaction_Status(String transaction_Status) {
		this.transaction_Status = transaction_Status;
	}

	public String getError_Log() {
		return error_Log;
	}

	public void setError_Log(String error_Log) {
		this.error_Log = error_Log;
	}

	public String getError_Message() {
		return error_Message;
	}

	public void setError_Message(String error_Message) {
		this.error_Message = error_Message;
	}

	public boolean isFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(boolean fulfilled) {
		this.fulfilled = fulfilled;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Date getPayment_Date() {
		return payment_Date;
	}

	public void setPayment_Date(Date payment_Date) {
		this.payment_Date = payment_Date;
	}
	
	

}
