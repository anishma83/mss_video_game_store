package com.mss.store.videogame.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Table(name="CATEGORY")
@Entity
public class Category {
	
	@Id
	@Column(name="CATEGORYID")	private int 	category_Id;
	@Column(name="NAME")		private String 	name;
	@Column(name="DESCRIPTION")	private String	description;
	
	
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
