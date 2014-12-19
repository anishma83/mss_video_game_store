package com.mss.store.videogame.dao;


import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Customer;

@Transactional
@Service
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	private SessionFactory sessionfactory;


	public void setSessionFactory(SessionFactory sessionfactory){
		this.sessionfactory=sessionfactory;
	}
	
	@Override
	@Transactional
	public void save(Customer customer) {
		sessionfactory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> list() {
		List<Customer> customers;
		Session session=this.sessionfactory.getCurrentSession();
		customers = (List<Customer>) session.createQuery("from Customer").list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> lookupById(int customerId) {
		List<Customer> customers;
		Session session=this.sessionfactory.getCurrentSession();
		customers = (List<Customer>) session.createQuery("from Customer where customerID="+customerId).list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> lookupByEmail(String email) {
		List<Customer> customers;
		Session session= this.sessionfactory.getCurrentSession();
		customers = (List<Customer>) session.createQuery("from Customer where email="+email).list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Customer signedIn(String email) {
		List<Customer> customerList = null;
		Customer customer = null;
		Session session= this.sessionfactory.getCurrentSession(); 
		customerList = (List<Customer>) session.createQuery("from Customer where email= :email ").setParameter("email", email).list();
		if(customerList.size()>0)
		{
			customer = customerList.get(0);
		}
		return customer;
	}
	
}
