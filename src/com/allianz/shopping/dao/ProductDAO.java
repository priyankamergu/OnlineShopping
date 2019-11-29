package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Product;

public interface ProductDAO 
{
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int id);
	
	public List<Product> getALLProducts();
	public List<Product> getALLProductByName(String newPattern);
	public List<Product> getALLProductByPrice(float min,float max);
	public Product getProductById(int id);
	
	
	
	
	public List<Product> getAllProductByCategoryID(int id);
	
	
}
