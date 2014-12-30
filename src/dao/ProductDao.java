package com.mss.store.videogame.dao;

import java.util.List;

import com.mss.store.videogame.model.Product;

public interface ProductDao {
	
	public void save(Product product);
	public List<Product> list();
	public List<Product> lookupById(int id);
	public List<Product> lookupBySKU(String sku);
	public List<Product> lookupByCategoryId(int id);
	public List<Product> lookupBySupplierId(int supplierId);
	public List<Product> lookupByName(String name);
	public List<Product> search(String searchCol,String searchValue);
	public List<Product> lookupByPrice(int start, int end);
}
