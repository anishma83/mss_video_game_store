package com.mss.store.videogame.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mss.store.videogame.model.Product;
import com.mss.store.videogame.model.ShoppingCartItem;



public class ShoppingCart implements Serializable  {
	private static final long serialVersionUID = -4461143736086272397L;
	
	private Map<Long, ShoppingCartItem> items = new HashMap<Long, ShoppingCartItem>();
	
	public ShoppingCart() {
	}
	
	public List<ShoppingCartItem> getItems() {
		List<ShoppingCartItem> list = new ArrayList<ShoppingCartItem>(items.values());
		Collections.sort(list);
		return list;
	}
	
	public void addItem(Product product) {
		long productId = product.getProduct_Id();
		ShoppingCartItem item = items.get(productId);
		if (item != null) {
			item.incrementQuantity();
		} else {
			items.put(productId, new ShoppingCartItem(product, 1));
		}
	}
	
	///  neeed to be able to remove item
	// public void removeItem(){}
	
	public int getItemCount() {
		int count = 0;
		for (ShoppingCartItem item : items.values()) {
			count += item.getQuantity();
		}
		return count;
	}
	
	///why are you a  string?
	public String getTotalPrice() {
		int total = 0;
		for (ShoppingCartItem item : items.values()) {
			total += item.getUnit_Price();
		}
		return Integer.toString(total);
	}
	
	public void clear() {
		items.clear();
	}
}
