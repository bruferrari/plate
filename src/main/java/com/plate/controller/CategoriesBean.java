package com.plate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.plate.dao.impl.CategoriesDAOImpl;
import com.plate.model.Categories;
import com.plate.service.CategoriesService;

/**
 * @author bruno ferrari
 *
 */

@Named
@ViewScoped
public class CategoriesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Categories> categories;
	@Inject private CategoriesDAOImpl dao;
	@Inject private Categories category;

	@PostConstruct
	public void init() {
		System.out.println("initializing...");
	}

	public void getAllCategories() {
		categories = new ArrayList<Categories>();
		categories = new CategoriesService().listAll();
	}

	public void deleteCategory() {
		new CategoriesService().delete(category);
	}

	public void editCategory() {
		new CategoriesService().edit(category);
	}

	public void saveCategory() {
		new CategoriesService().save(category);
	}

	/**
	 * @return
	 */
	public List<Categories> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 */
	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	/**
	 * @return
	 */
	public Categories getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(Categories category) {
		this.category = category;
	}

}
