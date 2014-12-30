package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Supplier;

@Transactional
@Service
public class SupplierDaoImpl extends HibernateDao<Supplier> implements SupplierDao{
	
	@Override
	public List<Supplier> lookupByCompanyName(String name) {
		Session session = currentSession();
		Query query=session.createQuery("From Supplier where company_Name= :name");
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Supplier> suppliers = query.list();
		return suppliers;
	}

	@Override
	public List<Supplier> lookupByEmail(String email) {
		Session session = currentSession();
		Query query = session.createQuery("From Supplier where email = :email");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<Supplier> suppliers = query.list();
		return suppliers;
	}

}
