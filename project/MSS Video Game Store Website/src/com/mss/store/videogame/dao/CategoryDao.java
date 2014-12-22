package com.mss.store.videogame.dao;

import java.util.List;

/**
 * @author Kyle Bissell
 * 
 */
import com.mss.store.videogame.model.Category;

public interface CategoryDao {
	
	/**
	 * Takes in a category and saves it to the database
	 * 
	 * @param category Category to save in the database
	 */
	public void save(Category category);
	
	/**
	 * Gives you a list of all the Cateogries in the database
	 * @return Returns a list of all of the Categorys in the database
	 */
	public List<Category> list();
	
	/**
	 * Lookups up the Categories with the given id
	 * @param id The Id to lookup
	 * @return The Cateogries with the given id
	 */
	public List<Category> lookupById(int id);
	
	/**
	 * Lookups up the Categories with the given name
	 * 
	 * @param name The name of the catagory you would like to get
	 * @return Returns a list of all of hte Categories with the given name
	 */
	public List<Category> lookupByName(String name);
	
	/**
	 * Takes the description given and looks it up in the database
	 * 
	 * @param description The descritpion of the category you want to lookup
	 * @return A list of all the Categories that have the given description
	 */
	public List<Category> lookupByDescription(String description);

}
