package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Order;

@Transactional
@Service
public class OrderDaoImpl implements OrderDao{
	
private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionfactory){
		this.sessionfactory=sessionfactory;
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		Session session= this.sessionfactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.persist(order);
		tx.commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> list() {
		List<Order> orders;
		Session session=this.sessionfactory.getCurrentSession();
		orders = (List<Order>) session.createQuery("from Order").list();
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> lookupById(int id) {
		List<Order> orders;
		Session session = this.sessionfactory.getCurrentSession();
		orders = (List<Order>)session.createQuery("from Order where order_Id = ?")
				.setInteger(0, id).list();
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> lookupByCustomerId(int id) {
		List<Order> orders;
		Session session = this.sessionfactory.getCurrentSession();
		orders = (List<Order>)session.createQuery("from Order where customer_Id = ?")
				.setInteger(0, id).list();
		return orders;
	}
}
