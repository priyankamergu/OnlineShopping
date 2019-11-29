package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.allianz.shopping.model.Customer;
import com.allianz.shopping.utility.DBUtilityConnection;

public class CustomerDAOImpl implements CustomerDAO
{

	@Override
	public boolean validate(String uname,String pass) {
		
		Connection con=DBUtilityConnection.getConnection();
		try
		{
			String sql="SELECT * FROM customer where Username=? and Password=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("valid user");
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean registeration(Customer customer) {
		Connection con=DBUtilityConnection.getConnection();
		try
		{
			String sql="INSERT INTO customer(Customer_Name,Customer_Mobile,Username,Password) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,customer.getCust_name());
			ps.setInt(2, customer.getCust_mobile());
			ps.setString(3, customer.getUsername());
			ps.setString(4, customer.getPassword());
			int res=ps.executeUpdate();
			if(res>=1)
			{
				System.out.println("Register");
				return true;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

}
