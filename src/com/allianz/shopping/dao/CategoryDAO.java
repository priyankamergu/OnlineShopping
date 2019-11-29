package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;

public interface CategoryDAO
{
	
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int id);
	
	public List<Category> getALLCategory();
	public List<Category> getALLCategoryByName(String newPattern);
	
	public Category getCategoryById(int id);
	
	public List<Category> getAllCategoryByProductId(int id);
	
	
	
}
