package com.mss.store.videogame.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="Suppliers")
public class Supplier{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SupplierId")				private int 	supplier_Id;
	@Column(name="CompanyName")				private String 	company_Name;
	@Column(name="ContactFName")			private String 	contact_Frist_Name;
	@Column(name="ContactLName")			private String 	contact_Last_Name;
	@Column(name="ContactTitle")			private String 	contact_Title;
	@Column(name="AddressLine1")			private String 	address_Line_1;
	@Column(name="AddressLine2")			private String 	address_Line_2;
	@Column(name="City")					private String	city;
	@Column(name="UsState")					private String	us_State;
	@Column(name="Postal")					private String	postal;
	@Column(name="Country")					private String	country;
	@Column(name="Phone")					private String	phone;
	@Column(name="Email")					private String	email;
	@Column(name="WebSite")					private String	website;
	@Column(name="CurrentOrder")			private String	current_Order;
	@Column(name="CustomerId")				private String 	customer_Id;
	@Column(name="Logo")					private String	logo;
	@Column(name="Notes")					private String 	notes;
	
	public Supplier()
	{
		
	}

	
	public int getSupplier_Id() {
		return supplier_Id;
	}

	public void setSupplier_Id(int supplier_id) {
		this.supplier_Id = supplier_id;
	}

	
	public String getCompany_Name() {
		return company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}

	
	
	public String getContact_Frist_Name() {
		return contact_Frist_Name;
	}

	public void setContact_Frist_Name(String contact_Frist_Name) {
		this.contact_Frist_Name = contact_Frist_Name;
	}

	
	public String getContact_Last_Name() {
		return contact_Last_Name;
	}

	public void setContact_Last_Name(String contact_Last_Name) {
		this.contact_Last_Name = contact_Last_Name;
	}

	
	public String getContact_Title() {
		return contact_Title;
	}

	public void setContact_Title(String contact_Title) {
		this.contact_Title = contact_Title;
	}

	
	
	public String getAddress_Line_1() {
		return address_Line_1;
	}

	public void setAddress_Line_1(String address_Line_1) {
		this.address_Line_1 = address_Line_1;
	}

	
	public String getAddress_Line_2() {
		return address_Line_2;
	}

	public void setAddress_Line_2(String address_Line_2) {
		this.address_Line_2 = address_Line_2;
	}

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	public String getUs_State() {
		return us_State;
	}

	public void setUs_State(String us_State) {
		this.us_State = us_State;
	}

	

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}

	
	
	public String getCurrent_Order() {
		return current_Order;
	}

	public void setCurrent_Order(String current_Order) {
		this.current_Order = current_Order;
	}

	
	
	public String getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}

	
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
