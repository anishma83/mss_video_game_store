package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Supplier;

public interface SupplierDao extends GenericDao<Supplier>{

	public List<Supplier> lookupByCompanyName(String name);
	public List<Supplier> lookupByEmail(String email);
	

}
