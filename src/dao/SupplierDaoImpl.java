package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Supplier;

@Transactional
@Service
public class SupplierDaoImpl implements SupplierDao{
	
private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionfactory){
		this.sessionfactory=sessionfactory;
	}

	@Override
	public void save(Supplier supplier) {
		Session session = this.sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(supplier);
		tx.commit();
		
	}

	@Override
	public List<Supplier> list() {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> suppliers = session.createQuery("From Supplier").list();
		return suppliers;
	}

	@Override
	public List<Supplier> lookupById(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> suppliers = session.createQuery("From Supplier where supplier_Id= ?").setParameter(0, id).list();
		return suppliers;
	}

	@Override
	public List<Supplier> lookupByCompanyName(String name) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> suppliers = session.createQuery("From Supplier where company_Name= ?").setParameter(0, name).list();
		return suppliers;
	}

	@Override
	public List<Supplier> lookupByEmail(String email) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> suppliers = session.createQuery("From Supplier where email = ?").setParameter(0, email).list();
		return suppliers;
	}

}
