package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Product;

@Transactional
@Service
public class ProductDaoImpl implements ProductDao{
	
private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionfactory){
		this.sessionfactory=sessionfactory;
	}

	@Override
	public void save(Product product) {
		Session session = this.sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(product);
		tx.commit();
		
	}

	@Override
	public List<Product> list() {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.createQuery("from Product").list();
		return products;
	}

	@Override
	public List<Product> lookupById(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.createQuery("from Product where product_Id = ?").setParameter(0, id).list();
		return products;
	}

	@Override
	public List<Product> lookupBySKU(String sku) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.createQuery("from Product where  sku = ?").setParameter(0, sku).list();
		return products;
	}

	@Override
	public List<Product> lookupByCategoryId(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.createQuery("from Product where category_Id = ?").setParameter(0, id).list();
		return products;
	}

	@Override
	public List<Product> lookupBySupplierId(int supplierId) {
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.createQuery("from Product where supllier_Id = ?").setParameter(0, supplierId).list();
		return products;
	}
	
	public List<Product> lookupByName(String name)
	{
		Session session = this.sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.createQuery("from Product where name =?").setString(0, name);
		return products;
	}
	
	public List<Product> search(String searchCol,String searchValue)
	{
		Session session = this.sessionfactory.getCurrentSession();
		
		Criteria query = session.createCriteria(Product.class);
		query.add(Restrictions.ilike(searchCol, searchValue, MatchMode.ANYWHERE));
		
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		
		return products;
	}

}
