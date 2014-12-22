package com.mss.store.videogame.test.dao;

import java.util.ArrayList;
import java.util.List;

import com.mss.store.videogame.dao.OrderDetailDao;
import com.mss.store.videogame.model.OrderDetail;

public class OrderDetailDaoTest implements OrderDetailDao{
	
	private List<OrderDetail> details = new ArrayList<OrderDetail>();

	@Override
	public void save(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetail> list() {
		// TODO Auto-generated method stub
		return createDetails();
	}

	@Override
	public List<OrderDetail> lookupById(int id) {
		// TODO Auto-generated method stub
		return createDetails();
	}

	@Override
	public List<OrderDetail> lookupByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return createDetails();
	}

	@Override
	public List<OrderDetail> lookupByProductId(int productId) {
		// TODO Auto-generated method stub
		return createDetails();
	}
	
	private List<OrderDetail> createDetails()
	{
		if(details.size()==0)
		{
			for(int i=1;i<4;i++)
			{
				OrderDetail d = new OrderDetail();
				d.setPrice(1);
				d.setFulfilled(false);
				d.setOrder_Detail_Id(i);
				d.setOrder_Id(-1);
				d.setQuantity(i);
				d.setSales_Tax(i);
				d.setShipper_Id(i);
				d.setTotal(d.getQuantity()*d.getPrice());
				d.setProduct_Id(i);
				details.add(d);
			}
		}
		return details;
	}

}
