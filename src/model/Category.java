package com.mss.store.videogame.model;

public class Category {
	private int 	category_Id;
	private String 	name;
	private String	description;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
