package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Customer;

@Transactional
@Service
@Repository
public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory sessionfactory;

	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		sessionfactory.getCurrentSession().save(customer);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> list() {
		List<Customer> customers;
		Session session = this.sessionfactory.getCurrentSession();
		customers = session.createQuery("from Customer").list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> lookupById(int customerId) {
		List<Customer> customers;
		Session session = this.sessionfactory.getCurrentSession();
		customers = session.createQuery(
				"from Customer where customerID=" + customerId).list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> lookupByEmail(String email) {
		List<Customer> customers;
		Session session = this.sessionfactory.getCurrentSession();
		customers = session.createQuery("from Customer where email=" + email)
				.list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Customer signedIn(String email) {
		List<Customer> customerList = null;
		Customer customer = null;
		Session session = this.sessionfactory.getCurrentSession();
		customerList = session
				.createQuery("from Customer where email= :email ")
				.setParameter("email", email).list();
		if (customerList.size() > 0) {
			customer = customerList.get(0);
		}
		return customer;
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {

		System.out.println("the values passed " + customer.toString());

		// customer= (Customer)
		// sessionfactory.getCurrentSession().merge(customer);
		sessionfactory.getCurrentSession().update(customer);

	}

	@Override
	public Customer merge(Customer customer) {
		Customer cust = (Customer) sessionfactory.getCurrentSession().merge(
				customer);
		return cust;
	}

}
