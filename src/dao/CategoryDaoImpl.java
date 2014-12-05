package com.mss.store.videogame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Category;

@Transactional
@Service
public class CategoryDaoImpl implements CategoryDao
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(category);
		tx.commit();
	}

	@Override
	public List<Category> list() {
	
		List<Category> categories;
		Session session = this.sessionFactory.getCurrentSession();
		categories = (List<Category>) session.createQuery("from Category");
		return categories;
	}

	@Override
	public List<Category> lookupById(int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoires = (List<Category>) session.createQuery("from Category where category_Id="+id);
		return categoires;
	}

	@Override
	public List<Category> lookupByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categories = (List<Category>) session.createQuery("from Category where name='"+name+"'");
		return categories;
	}

	@Override
	public List<Category> lookupByDescription(String description) {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categories = (List<Category>) session.createQuery("from Category where name='"+description+"'");
		return categories;
	}
	
}