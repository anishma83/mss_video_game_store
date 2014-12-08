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
	private int 	supplier_Id;
	private String 	company_Name;
	private String 	contact_Frist_Name;
	private String 	contact_Last_Name;
	private String 	contact_Title;
	private String 	address_Line_1;
	private String 	address_Line_2;
	private String	city;
	private String	us_State;
	private String	postal;
	private String	country;
	private String	phone;
	private String	email;
	private String	website;
	private String	current_Order;
	private String 	customer_Id;
	private String	logo;
	private String 	notes;
	
	public Supplier()
	{
		
	}

	@Id
	@Column(name="SupplierId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSupplier_Id() {
		return supplier_Id;
	}

	public void setSupplier_Id(int supplier_id) {
		this.supplier_Id = supplier_id;
	}

	@Column(name="CompanyName")
	public String getCompany_Name() {
		return company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}

	
	@Column(name="ContactFName")
	public String getContact_Frist_Name() {
		return contact_Frist_Name;
	}

	public void setContact_Frist_Name(String contact_Frist_Name) {
		this.contact_Frist_Name = contact_Frist_Name;
	}

	@Column(name="ContactLName")
	public String getContact_Last_Name() {
		return contact_Last_Name;
	}

	public void setContact_Last_Name(String contact_Last_Name) {
		this.contact_Last_Name = contact_Last_Name;
	}

	@Column(name="ContactTitle")
	public String getContact_Title() {
		return contact_Title;
	}

	public void setContact_Title(String contact_Title) {
		this.contact_Title = contact_Title;
	}

	
	@Column(name="AddressLine1")
	public String getAddress_Line_1() {
		return address_Line_1;
	}

	public void setAddress_Line_1(String address_Line_1) {
		this.address_Line_1 = address_Line_1;
	}

	@Column(name="AddressLine2")
	public String getAddress_Line_2() {
		return address_Line_2;
	}

	public void setAddress_Line_2(String address_Line_2) {
		this.address_Line_2 = address_Line_2;
	}

	@Column(name="City")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	@Column(name="UsState")
	public String getUs_State() {
		return us_State;
	}

	public void setUs_State(String us_State) {
		this.us_State = us_State;
	}

	
	@Column(name="Postal")
	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	
	@Column(name="Country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	@Column(name="Phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	@Column(name="Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Column(name="WebSite")
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}

	
	@Column(name="CurrentOrder")
	public String getCurrent_Order() {
		return current_Order;
	}

	public void setCurrent_Order(String current_Order) {
		this.current_Order = current_Order;
	}

	
	@Column(name="CustomerId")
	public String getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}

	
	@Column(name="Logo")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	@Column(name="Notes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
