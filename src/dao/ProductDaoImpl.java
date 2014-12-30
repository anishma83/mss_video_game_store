package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Product;

@Transactional
@Service
public class ProductDaoImpl extends HibernateDao<Product> implements ProductDao{



	@Override
	public List<Product> lookupBySKU(String sku) {
		Session session = currentSession();
		Query query =session.createQuery("from Product where  sku = :sku");
		query.setParameter("sku", sku);
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.list();
		return products;
	}

	@Override
	public List<Product> lookupByCategoryId(int categoryId) {
		Session session = currentSession();
		Query query = session.createQuery("from Product where category_Id = :categoryId");
		query.setParameter("categoryId", categoryId);
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.list();
		return products;
	}

	@Override
	public List<Product> lookupBySupplierId(int supplierId) {
		Session session = currentSession();
		Query query=session.createQuery("from Product where supllier_Id = :supplierId");
		query.setParameter("supplierId", supplierId);
		
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.list();
		return products;
	}
	
	public List<Product> lookupByName(String name)
	{
		Session session = currentSession();
		Query query=session.createQuery("from Product where name = :name");
		query.setString("name", name);
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.list();
		return products;
	}
	
	public List<Product> search(String searchCol,String searchValue)
	{
		Session session = currentSession();
		
		Criteria query = session.createCriteria(Product.class);
		query.add(Restrictions.ilike(searchCol, searchValue, MatchMode.ANYWHERE));
		
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		
		return products;
	}
	public List<Product> lookupByPrice(int start, int end)
	{
		Session session = currentSession();
		Query query = session.createQuery("from Product where unit_Price > :start AND unit_Price< :end");
		query.setInteger("start", start);
		query.setInteger("end", end);
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.list();
		return products;
	}
}
