package com.mss.store.videogame.invoice;

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


import com.mss.store.videogame.dao.*;
import com.mss.store.videogame.model.Customer;
import com.mss.store.videogame.model.Invoice;
import com.mss.store.videogame.model.Order;
import com.mss.store.videogame.model.OrderDetail;
import com.mss.store.videogame.model.Product;


import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author Anton Franklin
 *
 */
public class AutoUpdateDB {
	
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	@Autowired
	CustomerDao customerDao;
	@Autowired 
	OrderDao	orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	@Autowired
	ProductDao	productDao;
	
	private Invoice invoice;
	
	public AutoUpdateDB()
	{
		
	}
	
	
	/**
	 * Creates new AutoUpdateDB that will auto update the DB 
	 * @param invoice - have the items to be update throughout the DB
	 */
	public AutoUpdateDB(Invoice invoice)
	{
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
		   customerDao.save(cus);
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
	      orderDao.save(order);
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
		   for(OrderDetail d:details)
			   orderDetailDao.save(d);
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
		   
		   for(OrderDetail detail:details)
		   {
			   int index = searchForProductId(products, detail);
			   Product product = products.get(index);
			   product.setUnits_In_Stock(product.getUnits_In_Stock()-detail.getQuantity());
			   productDao.save(product);
		   }
		   
	   }
	   
	   private int searchForProductId(List<Product> products,OrderDetail detail)
	   {
		   int index=-1;
		   
		   for(int i=0;i<products.size();i++)
		   {
			   Product p=products.get(i);
			   if(p.getProduct_Id()==detail.getProduct_Id())
			   {
				   index=i;
				   break;
			   }
		   }
		   
		   return index;
	   }
	   
	   
}
