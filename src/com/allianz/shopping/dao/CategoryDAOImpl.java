package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DBUtilityConnection;
import com.allianz.shopping.utility.DateUtility;

public class CategoryDAOImpl  implements CategoryDAO
{
	
	@Override
	public boolean addCategory(Category category) 
	{
		Connection connection=null;		
		try
		{
			connection=DBUtilityConnection.getConnection();
			String sql="INSERT INTO category(Category_ID,Category_Code,Category_Desc) values(?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, category.getCategoryId());
			ps.setString(2, category.getCategoryCode());
			ps.setString(3, category.getCategoryDescription());			
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
	public boolean updateCategory(Category category) 
	{
		Connection connection=null;		
		try
		{
			connection=DBUtilityConnection.getConnection();
			String sql="UPDATE category SET Category_Code=? where Category_ID=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, category.getCategoryCode());
			ps.setInt(2, category.getCategoryId());			
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
	public boolean deleteCategory(int id) {
		
		Connection connection=null;		
		try
		{
			connection=DBUtilityConnection.getConnection();
			String sql="DELETE from category_ID where Category_ID=?";
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
	public List<Category> getALLCategory() {
		Connection connection=null;	
		List<Category> categoryList=new ArrayList<Category>();
		try
		{			
			connection=DBUtilityConnection.getConnection();
			String sql="SELECT * from category ";
			Statement stmt=connection.createStatement();			
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Category category=new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryCode(rs.getString(2));
				category.setCategoryDescription(rs.getString(3));
				
				categoryList.add(category);
			}
			return categoryList;
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Category> getALLCategoryByName(String newPattern) {
		Connection connection=null;	
		List<Category> CategoryList=new ArrayList<Category>();
		try
		{			
			connection=DBUtilityConnection.getConnection();
			String sql="SELECT * FROM category WHERE LOWER(Category_Code)=? ";
			
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,newPattern.toLowerCase());
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Category category=new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryCode(rs.getString(2));
				category.setCategoryDescription(rs.getString(3));
				
				CategoryList.add(category);
			}
			return CategoryList;
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Category getCategoryById(int id) {
		
		Connection connection=null;	
		try
		{	
			Category category=new Category();
			connection=DBUtilityConnection.getConnection();
			String sql="SELECT * FROM category WHERE Category_ID=? ";
			
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{				
				category.setCategoryId(rs.getInt(1));
				category.setCategoryCode(rs.getString(2));
				category.setCategoryDescription(rs.getString(3));
			}
			return category;
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Category> getAllCategoryByProductId(int id) {
		List<Category> clist=new ArrayList<Category>();
		Connection connection=null;	
		try
		{	
			
			connection=DBUtilityConnection.getConnection();
			String sql="SELECT * FROM category WHERE Category_ID in(select Category_ID from product_category where productID=? )";
			
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Category category=new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryCode(rs.getString(2));
				category.setCategoryDescription(rs.getString(3));
				
				clist.add(category);
				
			}
			return clist;
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
		return null;
	}

}
