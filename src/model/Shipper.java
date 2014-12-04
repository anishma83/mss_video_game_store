package com.mss.store.videogame.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Table(name="Shippers")
public class Shipper {
	private int 	shipper_Id;
	private String 	shipper_Name;
	private String 	phone;
	
	public Shipper()
	{
		
	}

	@Id
	@Column(name="ShiperId")
	public int getShipper_Id() {
		return shipper_Id;
	}

	public void setShipper_Id(int shipper_Id) {
		this.shipper_Id = shipper_Id;
	}

	
	@Column(name="ShipperName")
	public String getShipper_Name() {
		return shipper_Name;
	}

	public void setShipper_Name(String shipper_Name) {
		this.shipper_Name = shipper_Name;
	}

	
	@Column(name="Phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
