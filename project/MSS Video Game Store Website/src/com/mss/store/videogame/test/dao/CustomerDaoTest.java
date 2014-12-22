package com.mss.store.videogame.test.dao;

import java.util.ArrayList;
import java.util.List;

import com.mss.store.videogame.dao.CustomerDao;
import com.mss.store.videogame.model.Customer;

public class CustomerDaoTest implements CustomerDao{
	
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	@Override
	public void save(Customer customer) {
		return;
	}

	@Override
	public List<Customer> list() {
		return createCustomers();
	}

	@Override
	public List<Customer> lookupById(int customerId) {
		createCustomers();
		List<Customer> customer = new ArrayList<Customer>();
		
		customer.add(customers.get(0));
		return customer;
	}

	@Override
	public List<Customer> lookupByEmail(String email) {
		List<Customer> customer = new ArrayList<Customer>();
		customer.add(customers.get(0));
		return customer;
	}
	
	private List<Customer> createCustomers()
	{
		if(customers.size()==0)	
		{
			for(int i =0; i<10;i++)
			{
				Customer c = new Customer();
				c.setAddress_1("Customer"+i+" address 1");
				c.setAddress_2("Cusomter"+i+" address 2");
				c.setCity("Customer"+i+" City");
				c.setCountry("United States");
				c.setCustomer_Id(-i);
				c.setEmail("Customer"+i+"@email.com");
				c.setFirst_Name("Customer"+i);
				c.setLast_Name("Last"+i);
				customers.add(c);
			}
		}
		return customers;
	}

	@Override
	public Customer signedIn(String form_email) {
		// TODO Auto-generated method stub
		return null;
	}

}
