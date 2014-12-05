package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Shipper;

public interface ShipperDao {
	
	public void save(Shipper shipper);
	public List<Shipper> list();
	public List<Shipper> lookupById(int id);
	public List<Shipper> lookupByName(String name);

}
