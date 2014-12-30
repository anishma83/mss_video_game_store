package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Shipper;

public interface ShipperDao extends GenericDao<Shipper>{
	

	public List<Shipper> lookupByName(String name);

}
