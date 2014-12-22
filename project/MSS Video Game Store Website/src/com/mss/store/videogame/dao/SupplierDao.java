package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Supplier;

public interface SupplierDao {
	public void save(Supplier supplier);
	public List<Supplier> list();
	public List<Supplier> lookupById(int id);
	public List<Supplier> lookupByCompanyName(String name);
	public List<Supplier> lookupByEmail(String email);
	

}
