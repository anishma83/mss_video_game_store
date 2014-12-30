package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Product;

public interface ProductDao extends GenericDao<Product> {
	

	public List<Product> lookupBySKU(String sku);
	public List<Product> lookupByCategoryId(int id);
	public List<Product> lookupBySupplierId(int supplierId);
	public List<Product> lookupByName(String name);
	public List<Product> search(String searchCol,String searchValue);
	public List<Product> lookupByPrice(int start, int end);
}
