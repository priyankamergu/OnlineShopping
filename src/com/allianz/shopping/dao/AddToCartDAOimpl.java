package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.AddToCart;
import com.allianz.shopping.model.Order;
import com.allianz.shopping.utility.DBUtilityConnection;

public class AddToCartDAOimpl implements AddToCartDAO  
{
	@Override
	public boolean addToCart(AddToCart add)
	{
		Connection con=DBUtilityConnection.getConnection();
		String sql;
		try
		{
			sql="INSERT INTO add_to_cart(Order_ID,productID,quantity,Total_price) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, add.getOrder_id());
			ps.setInt(2,add.getProduct_id());
			ps.setInt(3, add.getQuantity());
			ps.setFloat(4,add.getTotal());
			int no=ps.executeUpdate();
			if(no>0)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<AddToCart> getAllAddToCartByOrderId(int order_id) {
		
		Connection con=DBUtilityConnection.getConnection();
		
		List<AddToCart> listadd=new ArrayList<AddToCart>();
		try
		{
			String sql="SELECT * FROM add_to_cart WHERE Order_ID=?";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setInt(1, order_id);
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				AddToCart addCart=new AddToCart();
				addCart.setAdd_To_Cart_id(rs.getInt(1));
				addCart.setOrder_id(rs.getInt(2));
				addCart.setProduct_id(rs.getInt(3));
				addCart.setQuantity(rs.getInt(4));
				addCart.setTotal(rs.getFloat(5));
				listadd.add(addCart);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return listadd;
		
	}


}
