package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Order;
import com.allianz.shopping.utility.DBUtilityConnection;
import com.allianz.shopping.utility.DateUtility;

public class OrderDAOImpl implements OrderDAO
{

	@Override
	public int addOrder(Order o) {
		int orderID = 0;
		Connection con=DBUtilityConnection.getConnection();
		String sql;
		
		try
		{
			sql="INSERT INTO orders(Order_Date,Status,Username,Total_Price) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setDate(1, DateUtility.convertUtilDateToSQLDate(o.getDate()));
			ps.setString(2,o.getOredr_status());
			ps.setString(3, o.getUserName());
			ps.setFloat(4, o.getPrice());
			int no=ps.executeUpdate();
			if(no>0)

			{
				try(ResultSet generateKeys=ps.getGeneratedKeys())
				{
					if(generateKeys.next())
					{
						orderID=generateKeys.getInt(1);
						System.out.println(orderID);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderID;
	}

	@Override
	public List<Order> getAllOrder()
	{		
		Connection con=DBUtilityConnection.getConnection();		
		List<Order> listOrder=new ArrayList<Order>();
		try
		{
			String sql="SELECT * FROM orders";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Order order=new Order();
				order.setOrder_id(rs.getInt(1));
				order.setDate(rs.getDate(2));
				order.setOredr_status(rs.getString(3));
				order.setUserName(rs.getString(4));
				order.setPrice(rs.getFloat(5));
				listOrder.add(order);
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return listOrder;
	}

	@Override
	public Order getOrderByOrderId(int order_id) {
		
		Connection con=DBUtilityConnection.getConnection();
		Order order=new Order();
		try
		{
			String sql="SELECT * FROM orders WHERE Order_ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, order_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{				
				order.setOrder_id(rs.getInt(1));
				order.setDate(rs.getDate(2));
				order.setOredr_status(rs.getString(3));
				order.setUserName(rs.getString(4));
				order.setPrice(rs.getFloat(5));				
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return order;
	}

	@Override
	public List<Order> getAllOrderByUserName(String username) 
	{
		List<Order> listOrder=new ArrayList<Order>();
		Connection con=DBUtilityConnection.getConnection();
		
		try
		{
			String sql="SELECT * FROM orders WHERE Username=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{		
				Order order=new Order();
				order.setOrder_id(rs.getInt(1));
				order.setDate(rs.getDate(2));
				order.setOredr_status(rs.getString(3));
				order.setUserName(rs.getString(4));
				order.setPrice(rs.getFloat(5));	
				listOrder.add(order);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return listOrder;
	}

}
