package com.mss.store.videogame.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mss.store.videogame.model.Category;


@Repository
public class CategoryDaoImpl extends HibernateDao<Category> implements CategoryDao
{

	@Override
	public List<Category> lookupByName(String name) {
		Session session =currentSession();
		Query query = session.createQuery("from Category where name= :name");
		query.setString("name", name);
		
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>) query.list();
		return categories;
	}

	@Override
	public List<Category> lookupByDescription(String description) {
		
		Session session =currentSession();
		Query query = session.createQuery("from Category where name= :description");
		query.setString("description", description);
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>) query.list();
		return categories;
	}
	
}