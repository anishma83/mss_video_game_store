package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.OrderDetail;


public interface OrderDetailDao extends GenericDao<OrderDetail> {
	

	public List<OrderDetail> lookupByOrderId(int orderId);
	public List<OrderDetail> lookupByProductId(int productId);
}
