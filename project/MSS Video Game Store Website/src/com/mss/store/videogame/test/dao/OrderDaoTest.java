package com.mss.store.videogame.test.dao;

import java.util.ArrayList;
import java.util.List;

import com.mss.store.videogame.dao.OrderDao;
import com.mss.store.videogame.model.Order;

public class OrderDaoTest implements OrderDao{
	
	private List<Order> orders = new ArrayList<Order>();

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> list() {
		// TODO Auto-generated method stub
		return createOrders();
	}

	@Override
	public List<Order> lookupById(int id) {
		// TODO Auto-generated method stub
		return createOrders();
	}

	@Override
	public List<Order> lookupByCustomerId(int id) {
		// TODO Auto-generated method stub
		return createOrders();
	}
	
	private List<Order> createOrders()
	{
		if(orders.size() == 0)
		{
			Order order = new Order();
			order.setCustomer_Id(-1);
			order.setFulfilled(false);
			order.setOrder_Id(-1);
			order.setPaid(false);
		}
			
		return orders;
	}

}
