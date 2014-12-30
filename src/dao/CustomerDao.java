package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Customer;

public interface CustomerDao extends GenericDao<Customer> {

	

	public void updateCustomer(Customer customer);

	public Customer merge(Customer customer);


	public List<Customer> lookupByEmail(String email);

	public Customer signedIn(String form_email);

	Customer signedIn(String email, String password);

}
