package com.mss.store.videogame.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Table(name = "ECOMMERCECUSTOMER")
@Entity
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerId")
	private int customer_Id;
	@Column(name = "FirstName")
	private String first_Name;
	@Column(name = "LastName")
	private String last_Name;
	@Column(name = "Address1")
	private String address_1;
	@Column(name = "Address2")
	private String address_2;
	@Column(name = "City")
	private String city;
	@Column(name = "UsState")
	private String us_State;
	@Column(name = "Postal")
	private String postal;
	@Column(name = "Country")
	private String country;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "Email")
	private String email;
	@Column(name = "Password")
	private String password;
	@Column(name = "CreditCard")
	private String credit_Card;
	@Column(name = "CreditCardId")
	private String credit_Card_Id;
	@Column(name = "CreditExMo")
	private String credit_Expiration_Month;
	@Column(name = "CeditExYr")
	private String credit_Expiration_Year;
	@Column(name = "BillingAddress")
	private String billing_Address;
	@Column(name = "BillingAddress2")
	private String billing_Address_1;
	@Column(name = "BillingCity")
	private String billing_City;
	@Column(name = "BillingState")
	private String billing_State;
	@Column(name = "BillingPostal")
	private String billing_Postal;
	@Column(name = "BillingCountry")
	private String billing_Country;
	@Column(name = "DateEntered")
	private Date date_Entered;
	@Column(name = "Member")
	private String member;
	@Transient
	private boolean is_Logged_In;
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Order.class, mappedBy = "customer_Id")
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Customer() {
		is_Logged_In = false;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getCity() {
		return city;
	}

	@Transient
	public boolean isIs_Logged_In() {
		return is_Logged_In;
	}

	@Transient
	public void setIs_Logged_In(boolean is_Logged_In) {
		this.is_Logged_In = is_Logged_In;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCredit_Card() {
		return credit_Card;
	}

	public void setCredit_Card(String credit_Card) {
		this.credit_Card = credit_Card;
	}

	public String getCredit_Card_Id() {
		return credit_Card_Id;
	}

	public void setCredit_Card_Id(String credit_Card_Id) {
		this.credit_Card_Id = credit_Card_Id;
	}

	public String getCredit_Expiration_Month() {
		return credit_Expiration_Month;
	}

	public void setCredit_Expiration_Month(String credit_Expiration_Month) {
		this.credit_Expiration_Month = credit_Expiration_Month;
	}

	public String getCredit_Expiration_Year() {
		return credit_Expiration_Year;
	}

	public void setCredit_Expiration_Year(String credit_Expiration_Year) {
		this.credit_Expiration_Year = credit_Expiration_Year;
	}

	public String getBilling_Address() {
		return billing_Address;
	}

	public void setBilling_Address(String billing_Address) {
		this.billing_Address = billing_Address;
	}

	public String getBilling_Address_1() {
		return billing_Address_1;
	}

	public void setBilling_Address_1(String billing_Address_1) {
		this.billing_Address_1 = billing_Address_1;
	}

	public String getBilling_City() {
		return billing_City;
	}

	public void setBilling_City(String billing_City) {
		this.billing_City = billing_City;
	}

	public String getBilling_State() {
		return billing_State;
	}

	public void setBilling_State(String billing_State) {
		this.billing_State = billing_State;
	}

	public String getBilling_Postal() {
		return billing_Postal;
	}

	public void setBilling_Postal(String billing_Postal) {
		this.billing_Postal = billing_Postal;
	}

	public String getBilling_Country() {
		return billing_Country;
	}

	public void setBilling_Country(String billing_Country) {
		this.billing_Country = billing_Country;
	}

	public Date getDate_Entered() {
		return date_Entered;
	}

	public void setDate_Entered(Date date_Entered) {
		this.date_Entered = date_Entered;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

}
