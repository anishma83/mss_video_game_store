package com.mss.store.videogame.model;

public class Product {
	private int 	product_Id;
	private String	sku;
	private String	supplier_Product_Id;
	private String	product_Name;
	private int		supplier_Id;
	private int		category_Id;
	private double	unit_Price;
	private int		units_In_Stock;
	private int		units_On_Order;
	private int		reorder_Level;
	private String	product_Availability;
	private String	image;
	private String	notes;
	

	public Product() {
		
	}


	public int getProduct_Id() {
		return product_Id;
	}


	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getSupplier_Product_Id() {
		return supplier_Product_Id;
	}


	public void setSupplier_Product_Id(String supplier_Product_Id) {
		this.supplier_Product_Id = supplier_Product_Id;
	}


	public String getProduct_Name() {
		return product_Name;
	}


	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}


	public int getSupplier_Id() {
		return supplier_Id;
	}


	public void setSupplier_Id(int supplier_Id) {
		this.supplier_Id = supplier_Id;
	}


	public int getCategory_Id() {
		return category_Id;
	}


	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}


	public double getUnit_Price() {
		return unit_Price;
	}


	public void setUnit_Price(double unit_Price) {
		this.unit_Price = unit_Price;
	}


	public int getUnits_In_Stock() {
		return units_In_Stock;
	}


	public void setUnits_In_Stock(int units_In_Stock) {
		this.units_In_Stock = units_In_Stock;
	}


	public int getUnits_On_Order() {
		return units_On_Order;
	}


	public void setUnits_On_Order(int units_On_Order) {
		this.units_On_Order = units_On_Order;
	}


	public int getReorder_Level() {
		return reorder_Level;
	}


	public void setReorder_Level(int reorder_Level) {
		this.reorder_Level = reorder_Level;
	}


	public String getProduct_Availability() {
		return product_Availability;
	}


	public void setProduct_Availability(String product_Availability) {
		this.product_Availability = product_Availability;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
