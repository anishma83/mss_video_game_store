package com.mss.store.videogame.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//so it can be passed
import java.io.Serializable;

@Entity
@Table(name="Product")
public class Product implements Comparable<Product>, Serializable{
	private static final long serialVersionUID = -6027340279914938585L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductId")			private int 	product_Id;
	@Column(name="Sku")					private String	sku;
	@Column(name="SupplierProductId")	private String	supplier_Product_Id;
	@Column(name="ProductName")			private String	product_Name;
	@Column(name="SupplierId")			private int		supplier_Id;
	@Column(name="CategoryId")			private int		category_Id;
	@Column(name="UnitPrice")			private double	unit_Price;
	@Column(name="UnitsInStock")		private int		units_In_Stock;
	@Column(name="UnitesOnOrder")		private int		units_On_Order;
	@Column(name="ReOrdeLevel")			private int		reorder_Level;
	@Column(name="ProductAvailability")	private String	product_Availability;
	@Column(name="Image")				private String	image;
	@Column(name="Notes")				private String	notes;
	@ManyToOne(targetEntity=Category.class)
	@JoinColumn(name="categoryId")
										private Category category;
	@ManyToOne(targetEntity=Supplier.class)
	@JoinColumn(name="supplierId")
										private Supplier supplier;
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

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

	// / needed for shopping cart
	@Override
	public boolean equals(Object o) {
		return o instanceof Product && product_Id == ((Product) o).product_Id;
	}

	@Override
	public int hashCode() {
		return ((Integer) product_Id).hashCode();
	}

	@Override
	public int compareTo(Product p) {
		int c = sku.compareTo(p.sku);
		return (c == 0 ? ((Integer) product_Id)
				.compareTo((Integer) p.product_Id) : c);
	}
	
}
