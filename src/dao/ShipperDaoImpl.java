package com.mss.store.videogame.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Shipper;

@Transactional
@Service
public class ShipperDaoImpl extends HibernateDao<Shipper> implements ShipperDao{


	@Override
	public List<Shipper> lookupByName(String name) {
		Session session = currentSession();
		Query query = session.createQuery("from Shipper where shipper_Name = :name");
		query.setParameter("name", name);
		
		@SuppressWarnings("unchecked")
		List<Shipper> shippers = query.list();
		return shippers;
	}

}
