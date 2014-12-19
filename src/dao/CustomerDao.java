package com.mss.store.videogame.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mss.store.videogame.model.Customer;

public interface CustomerDao {
	
	public void save(Customer customer);
	public List<Customer> list();
	public List<Customer> lookupById(int customerId);
	public List<Customer> lookupByEmail(String email);
	public List<Customer> signedIn(String form_email);

}
