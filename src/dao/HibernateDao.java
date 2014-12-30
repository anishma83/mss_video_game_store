package com.mss.store.videogame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class HibernateDao<E> implements GenericDao<E> {
		 
		@Autowired
	    private SessionFactory sessionFactory;
	    protected Class<? extends E> daoType;
	 
	    public HibernateDao() {
	        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
	                        .getActualTypeArguments()[0];
	    }
	 
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	    protected Session currentSession() {
	        return sessionFactory.getCurrentSession();
	    }
	 
	    @Override
	    public void save(E entity) {
	        currentSession().save(entity);
	    }
	 
	    @Override
	    public void update(E entity) {
	        currentSession().saveOrUpdate(entity);
	    }
	 
	    @Override
	    public void remove(E entity) {
	        currentSession().delete(entity);
	    }
	 
	    @Override
	    public E lookupById(int key) {
	        return (E) currentSession().get(daoType, key);
	    }
	 
	    @Override
	    public List<E> list() {
	        return currentSession().createCriteria(daoType).list();
	    }

}
