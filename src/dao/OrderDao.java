package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Order;

public interface OrderDao extends GenericDao<Order> {

	public List<Order> lookupByCustomerId(int id);

}
