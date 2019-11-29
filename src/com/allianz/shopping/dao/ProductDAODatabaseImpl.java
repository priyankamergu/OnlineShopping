package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DBUtilityConnection;
import com.allianz.shopping.utility.DateUtility;

public class ProductDAODatabaseImpl implements ProductDAO
{
	CategoryDAO cdao=new CategoryDAOImpl();
	@Override
	public boolean addProduct(Product product) 
	{
		Connection connection=null;		
		try
		{
			connection=DBUtilityConnection.getConnection();
			String sql="INSERT INTO product(productID,productCode,productDescription,productPrice,productDate) values(?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getCode());
			ps.setString(3, product.getDescription());
			ps.setFloat(4, product.getPrice());
			ps.setDate(5,DateUtility.convertUtilDateToSQLDate(product.getManfDate()));			
			int no=ps.executeUpdate();
			if(no>0)
				return true;
							
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) 
	{
		Connection connection=null;		
		try
		{
			connection=DBUtilityConnection.getConnection();
			String sql="UPDATE product SET  productCode= ? where productID=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, product.getCode());
			ps.setInt(2, product.getId());			
			int no=ps.executeUpdate();
			if(no>0)
				return true;									
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) 
	{
		Connection connection=null;		
		try
		{
			connection=DBUtilityConnection.getConnection();
			String sql="DELETE from product where productID=?";
			PreparedStatement ps=connection.prepareStatement(sql);			
			ps.setInt(1, id);			
			int no=ps.executeUpdate();
			if(no>0)
				return true;									
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getALLProducts() 
	{
		Connection connection=null;	
	
		List<Product> productList=new ArrayList<Product>();
		try
		{			
			connection=DBUtilityConnection.getConnection();
			String sql="SELECT * from product ";
			Statement stmt=connection.createStatement();			
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Product product=new Product();
				product.setId(rs.getInt(1));
				product.setCode(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getFloat(4));
				product.setManfDate(rs.getDate(5));
				product.setCategoryList(cdao.getAllCategoryByProductId(product.getId()));
				productList.add(product);
			}
			return productList;
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Product> getALLProductByName(String newPattern)
	{
		
		Connection connection=null;	
		List<Product> productList=new ArrayList<Product>();
		try
		{			
			connection=DBUtilityConnection.getConnection();
			String sql="SELECT * FROM product WHERE LOWER(productCode)=? ";
			
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,newPattern.toLowerCase());
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setId(rs.getInt(1));
				product.setCode(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getFloat(4));
				product.setManfDate(rs.getDate(5));
				productList.add(product);
			}
			return productList;
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Product> getALLProductByPrice(float min, float max) 
	{
		Connection connection=null;	
		List<Product> productList=new ArrayList<Product>();
		try
		{			
			connection=DBUtilityConnection.getConnection();
			String sql="SELECT * FROM product WHERE productPrice BETWEEN ? AND ?";
			
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setFloat(1, min);
			ps.setFloat(2, max);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setId(rs.getInt(1));
				product.setCode(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getFloat(4));
				product.setManfDate(rs.getDate(5));
				productList.add(product);
			}
			return productList;
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public Product getProductById(int id) 
	{
		Connection connection=null;	
		try
		{	
			Product product=new Product();
			connection=DBUtilityConnection.getConnection();
			String sql="SELECT * FROM product WHERE productID=? LIMIT 1";
			
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next()) {
				
				product.setId(rs.getInt("productID"));
				product.setCode(rs.getString("productCode"));
				product.setDescription(rs.getString("productDescription"));
				product.setPrice(rs.getFloat("productPrice"));
				product.setManfDate(rs.getDate("productDate"));
				product.setCategoryList(cdao.getAllCategoryByProductId(product.getId()));
			return product;
			}
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Product> getAllProductByCategoryID(int id) {
		Connection connection=null;	
		connection=DBUtilityConnection.getConnection();
		String sql="SELECT * FROM product WHERE productID in (select productID from product_category where Category_ID = ? )";
		
		List<Product> productList=new ArrayList<Product>();
		try
		{	
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product product=new Product();

				product.setId(rs.getInt(1));
				product.setCode(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getFloat(4));
				product.setManfDate(rs.getDate(5));
				product.setCategoryList(cdao.getAllCategoryByProductId(product.getId()));
				
				System.out.println(product);
				productList.add(product);			
			}
			
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return productList;
		
	}
	
}
