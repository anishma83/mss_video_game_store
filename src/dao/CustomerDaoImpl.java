package com.mss.store.videogame.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Customer;

@Transactional
@Service
public class CustomerDaoImpl implements CustomerDao {
	
	private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionfactory){
		this.sessionfactory=sessionfactory;
	}

	@Override
	public void save(Customer customer) {
		Session session= this.sessionfactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.persist(customer);
		tx.commit();
		
	}

	@Override
	public List<Customer> list() {
		List<Customer> customers;
		Session session=this.sessionfactory.getCurrentSession();
		customers = (List<Customer>) session.createQuery(" * from ECOMMERCECUSTOMER");
		return customers;
	}

	@Override
	public List<Customer> lookupById(int customerId) {
		List<Customer> customers;
		Session session=this.sessionfactory.getCurrentSession();
		customers = (List<Customer>) session.createQuery(" * from ECOMMERCECUSTOMER where customerID="+customerId);
		return customers;
	}

	@Override
	public List<Customer> lookupByEmail(String email) {
		List<Customer> customers;
		Session session= this.sessionfactory.getCurrentSession();
		customers = (List<Customer>) session.createQuery("* from ECOMMERCECUSTOMER where email="+email);
		return customers;
	}

	
}
