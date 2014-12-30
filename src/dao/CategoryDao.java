package com.mss.store.videogame.dao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kyle Bissell
 * 
 */
import com.mss.store.videogame.model.Category;

public interface CategoryDao extends GenericDao<Category>{



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
