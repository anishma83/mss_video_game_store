package com.ms.store.videogame.invoice;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import com.ms.store.videogame.model.Customer;
import com.ms.store.videogame.model.Invoice;
import com.ms.store.videogame.model.Order;
import com.ms.store.videogame.model.OrderDetail;
import com.ms.store.videogame.model.Product;

/**
 * 
 * @author Anton Franklin
 *
 */
public class AutoUpdateDB {
	
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	private Invoice invoice;
	
	/**
	 * Creates new AutoUpdateDB that will auto update the DB 
	 * @param invoice - have the items to be update throughout the DB
	 */
	public AutoUpdateDB(Invoice invoice)
	{
		try{
		Configuration configuration = new Configuration();
	    configuration.configure();
	    
	    configuration.addAnnotatedClass(Customer.class);
	    configuration.addAnnotatedClass(Order.class);
	    configuration.addAnnotatedClass(OrderDetail.class);
	    configuration.addAnnotatedClass(Product.class);
	    
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    
	    factory = configuration.buildSessionFactory(serviceRegistry);
	         
	    }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
		
		this.invoice = invoice;
	}
	
	/**
	 * Runs the necessary methods of AuotUpdateDB. 
	 * The only method call from the controller in this class.
	 */
	public void run()
	{
		updateCustomer(this.invoice.getCustomer());
		updateOrder(this.invoice.getOrder());
		updateOrderDetail(this.invoice.getOrderDetails());
		updateProduct(this.invoice.getProducts(), this.invoice.getOrderDetails());
	}
	
	
	/**
	 * Method to UPDATE Customer
	 * @param cus - Customer to be updated
	 */
	   public void updateCustomer(Customer cus){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.update(cus); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE an Customer from the records 
	   /**
	    * 
	    * @param cus
	    *
	   public void deleteCustomer(Customer cus){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.delete(cus); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }*/
	   
	  /**
	    * Method to UPDATE Order
	    * @param order - the order that has been processed
	    */
	   public void updateOrder(Order order){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      order.setTransaction_Status("complete");
	      order.setFulfilled(true);
	      order.setPaid(true);
	      
	      
	      java.util.Date utilDate = new java.util.Date();
	     
	      Date date = new java.sql.Date(utilDate.getTime());
	      
	      order.setPayment_Date(date);
	      
	      try{
	         tx = session.beginTransaction();
	         session.update(order); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   	   
	   /* Method to DELETE an Order from the records 
	   /**
	    * 
	    * @param order
	    *
	   public void deleteOrder(Order order){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.delete(order); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }*/
	
	   
	   /**
	    * Method to UPDATE OrderDetail
	    * @param details - list of order details for processed order
	    */
	   public void updateOrderDetail(List<OrderDetail> details){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try{
	    	  tx = session.beginTransaction();
	    	  for(int i=0; i<details.size(); i++)
		      {
		    	  details.get(i).setFulfilled(true);
		    	  
		    	  /*Calculates the beginning shipping process*/
		    	  java.util.Date dt = new java.util.Date();
		    	  Calendar c = Calendar.getInstance(); 
		    	  c.setTime(dt); 
		    	  c.add(Calendar.DATE, 1);
		    	  dt = c.getTime();
		    	  
		    	  Date date = new java.sql.Date(dt.getTime());
		    	  
		    	  details.get(i).setShip_Date(date);
		    	  session.update(details.get(i));
		    	  tx.commit();
		      }
	      
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE an OrderDetail from the records 
	   /**
	    * 
	    * @param details
	    *
	   public void deleteCustomerOrderDetail(OrderDetail details){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.delete(details); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }*/
	   
	   
	   /**
	    * Method to UPDATE Products bought by customer
	    * @param products - the list of products purchased by customer
	    * @param details - the list of order details that coincide with the order
	    */
	   public void updateProduct(List<Product> products, List<OrderDetail> details){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         for(int i=0; i<products.size(); i++) 
	         {
	        	 for(int j=0; j<details.size(); j++)
	        	 {
	        		 /*This will remove the orders products from the DB products number of items*/
	        		 if(details.get(j).getProduct_Id() == products.get(i).getProduct_Id())
	        		 {
	        			int numItems =  products.get(i).getUnits_In_Stock();
	        			numItems = numItems - details.get(j).getQuantity();
	        			products.get(i).setUnits_In_Stock(numItems);
	        		 }
	        	 }
	        	 
	        	 session.update(products.get(i)); 
		         tx.commit(); 
	         }
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   
}
