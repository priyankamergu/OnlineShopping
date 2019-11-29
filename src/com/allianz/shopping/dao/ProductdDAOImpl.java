package com.allianz.shopping.dao;

import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;
//import static com.allianz.shopping.utility.DateUtility.*; we can use directly lie=ke convertStringToDate
public class ProductdDAOImpl implements ProductDAO
{

	
	private static List<Product> productList=new ArrayList<Product>();
	
	static
	{
		productList.add(new Product(101,"colgate1","Colgate1 Tube",50,DateUtility.convertStringToDate("12/10/2019")));//you can import static com.allianz.shppoinh.tutitly if you dont want to use thorugh class name
		productList.add(new Product(102,"colgate2","Colgate2 Tube",60,DateUtility.convertStringToDate("14/10/2019")));
		productList.add(new Product(103,"colgate3","Colgate3 Tube",40,DateUtility.convertStringToDate("13/10/2019")));
		productList.add(new Product(104,"colgate4","Colgate4 Tube",70,DateUtility.convertStringToDate("15/10/2019")));
		productList.add(new Product(105,"colgate5","Colgate5 Tube",80,DateUtility.convertStringToDate("18/10/2019")));
	}
	
	
	@Override
	public boolean addProduct(Product product) {
		productList.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getId()==product.getId())
				{
					productList.set(i,product);
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteProduct(int id) 
	{
		
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getId()==id)
				{
					productList.remove(i);
					return true;
				}
			}
		}	
		
		return false;
	}

	@Override
	public List<Product> getALLProducts()
	{
		
		return productList;
	}

	@Override
	public List<Product> getALLProductByName(String namePattern) 
	{
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getDescription().toLowerCase().contains(namePattern.toLowerCase()))
				{
					List<Product> list=new ArrayList<Product>();
					list.add(productTemp);
					return list;
				}
			}
		}
		return null;
	}

	@Override
	public List<Product> getALLProductByPrice(float min,float max) 
	{
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getPrice()>=min && productTemp.getPrice()<=max)
				{
					List<Product> list=new ArrayList<Product>();
					list.add(productTemp);
					return list;
				}
			}
			
		}
		return null;
	}

	@Override
	public Product getProductById(int id) {
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getId()==id)
				{					
					return productTemp;
				}
			}
		}
		return null;
	}


	@Override
	public List<Product> getAllProductByCategoryID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
