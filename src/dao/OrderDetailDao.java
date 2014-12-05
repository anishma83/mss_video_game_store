package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.OrderDetail;

public interface OrderDetailDao {
	
	public void save(OrderDetail orderDetail);
	public List<OrderDetail> list();
	public List<OrderDetail> lookupById(int id);
	public List<OrderDetail> lookupByOrderId(int orderId);
	public List<OrderDetail> lookupByProductId(int productId);
}
