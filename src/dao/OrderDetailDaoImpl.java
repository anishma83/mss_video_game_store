package com.mss.store.videogame.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.OrderDetail;

@Transactional
@Service
public class OrderDetailDaoImpl extends HibernateDao<OrderDetail> implements OrderDetailDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> lookupByOrderId(int orderId) {
		Session session = currentSession();
		Query query =session.createQuery("from OrderDetail where orderId= :orderId");
		query.setParameter("orderId", orderId);
		
		List<OrderDetail>  orderdetails=(List<OrderDetail>) query.list();
		
		return orderdetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> lookupByProductId(int productId) {
		Session session = currentSession();
		Query query = session.createQuery("from OrderDetail where productId= :productId");
		query.setParameter("productId", productId);
		
		List<OrderDetail> orderdetails=(List<OrderDetail>) query.list();
		
		return orderdetails;
	}
}
	
