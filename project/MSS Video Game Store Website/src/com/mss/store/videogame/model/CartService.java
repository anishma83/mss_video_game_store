package com.mss.store.videogame.model;

import java.util.List;



public interface CartService {
	
	ShoppingCart getShoppingCart();
	
	List<Product> getProducts();
	
	List<Product> getRecommendations();
	
	Product getProduct(int productId);
	
	List<String> getShippingOptions();
	
	void submitOrderForPayment();
}
