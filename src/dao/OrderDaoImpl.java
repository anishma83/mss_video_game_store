package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Order;

@Transactional
@Service
public class OrderDaoImpl extends HibernateDao<Order> implements OrderDao{
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Order> lookupByCustomerId(int id) {
		
		Session session = currentSession();
		Query query = session.createQuery("from Order where customer_Id = :customerId");
		query.setParameter("customerId", id);
		List<Order> orders = (List<Order>)query.list();
		return orders;
	}
}
