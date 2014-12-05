package com.mss.store.videogame.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.OrderDetail;

@Transactional
@Service
public class OrderDetailDaoImpl implements OrderDetailDao{
	private SessionFactory sessionfactory;
	
	public void setSessionFactory(){
		this.sessionfactory=sessionfactory;
	}

	@Override
	public void save(OrderDetail orderDetail) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(orderDetail);
		tx.commit();
	}

	@Override
	public List<OrderDetail> list() {
		List<OrderDetail> orderdetails;
		Session session = sessionfactory.getCurrentSession();
		orderdetails=(List<OrderDetail>) session.createQuery("from OrderDetails").list();
		return orderdetails;
	}

	@Override
	public List<OrderDetail> lookupById(int id) {
		List<OrderDetail> orderdetails;
		Session session = sessionfactory.getCurrentSession();
		orderdetails=(List<OrderDetail>) session.createQuery("from OrderDetails where id=" + id).list();
		return orderdetails;
	}

	@Override
	public List<OrderDetail> lookupByOrderId(int orderId) {
		List<OrderDetail> orderdetails;
		Session session = sessionfactory.getCurrentSession();
		orderdetails=(List<OrderDetail>) session.createQuery("from OrderDetails where orderId=" + orderId).list();
		return orderdetails;
	}

	@Override
	public List<OrderDetail> lookupByProductId(int productId) {
		List<OrderDetail> orderdetails;
		Session session = sessionfactory.getCurrentSession();
		orderdetails=(List<OrderDetail>) session.createQuery("from OrderDetails where productId=" + productId).list();
		return orderdetails;
	}
}
	
