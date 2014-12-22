package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Order;

public interface OrderDao {
	public void save(Order order);
	public List<Order> list();
	public List<Order> lookupById(int id);
	public List<Order> lookupByCustomerId(int id);

}
