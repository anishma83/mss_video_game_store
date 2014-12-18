package com.mss.store.videogame.model;

import java.io.Serializable;

import com.mss.store.videogame.model.Product;



public class ShoppingCartItem implements Comparable<ShoppingCartItem>, Serializable {
	private static final long serialVersionUID = 4134652647253355430L;
	
	private Product product;
	private int quantity;
	
	public ShoppingCartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void incrementQuantity() {
		quantity++;
	}

	public double getUnit_Price() {
		return product.getUnit_Price();
	}
	
	
	
	public double getTotalPriceInCents() {
		return (quantity * getUnit_Price());
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		return o instanceof ShoppingCartItem &&
			product.equals(((ShoppingCartItem) o).product);
	}
	
	@Override
	public int hashCode() {
		return product.hashCode();
	}
	
	@Override
	public int compareTo(ShoppingCartItem item) {
		return product.compareTo(item.product);
	}
}