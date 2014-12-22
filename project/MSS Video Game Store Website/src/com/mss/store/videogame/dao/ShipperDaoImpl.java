package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Shipper;

@Transactional
@Service
public class ShipperDaoImpl implements ShipperDao{
	private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionfactory){
		this.sessionfactory=sessionfactory;
	}
		
	
	
	@Override
	public void save(Shipper shipper) {
		Session session = this.sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(shipper);
		tx.commit();
		
	}

	@Override
	public List<Shipper> list() {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Shipper> shippers = session.createQuery("from Shipper").list();
		return shippers;
	}

	@Override
	public List<Shipper> lookupById(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Shipper> shippers = session.createQuery("from Shipper where shipper_Id = ?").setParameter(0, id).list();
		return shippers;
	}

	@Override
	public List<Shipper> lookupByName(String name) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Shipper> shippers = session.createQuery("from Shipper where shipper_Name = ?").setParameter(0, name).list();
		return shippers;
	}

}
