package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Customer;

public interface CustomerDao {

	public void save(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer merge(Customer customer);

	public List<Customer> list();

	public List<Customer> lookupById(int customerId);

	public List<Customer> lookupByEmail(String email);

	public Customer signedIn(String form_email);

}
