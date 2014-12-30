package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Customer;


@Repository
public class CustomerDaoImpl extends HibernateDao<Customer> implements CustomerDao {

	

	@Override
	public List<Customer> lookupByEmail(String email) {
		Session session = currentSession();
		
		Query query = session.createQuery("from Customer where email= :email");
		query.setString("email", email);
		
		List<Customer> customers = query.list();
		
		return customers;
	}

	@Override
	public Customer signedIn(String email) {
		Session session = currentSession();
		Query query = session.createQuery("from Customer where email= :email ");
		query.setParameter("email", email);
		
		Customer customer = (Customer) query.uniqueResult();

		return customer;
	}
	
	@Override
	public Customer signedIn(String email,String password) {
		Session session = currentSession();
		Query query = session.createQuery("from Customer where email= :email and password = :password");
		query.setString("email", email);
		query.setString("password", password);
		
		Customer customer = (Customer) query.uniqueResult();

		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {

		System.out.println("the values passed " + customer.toString());
		//TODO Add Customer Logic

		update(customer);

	}

	@Override
	public Customer merge(Customer customer) {
		Customer newCustomer = (Customer) currentSession().merge(
				customer);
		return newCustomer;
	}

}
