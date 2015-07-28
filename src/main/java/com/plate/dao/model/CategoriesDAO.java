package com.plate.dao.model;

import java.util.List;

import com.plate.model.Categories;

public interface CategoriesDAO {
	
	/**
	 * @return
	 */
	List<Categories> listAll();
	
	/**
	 * @param category
	 */
	void delete(Categories category);
	
	/**
	 * @param category
	 * @return
	 */
	Categories saveOrUpdateCategory(Categories category);
	
	/**
	 * @param keyword
	 * @return
	 */
	List<Categories> search(String keyword);

}
