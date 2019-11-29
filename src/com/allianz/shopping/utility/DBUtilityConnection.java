
package com.allianz.shopping.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilityConnection
{
	public static Connection getConnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); //creating object of my sql driver
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping?serverTimezone=UTC", "root", "");
			return connection;
		}
		catch(ClassNotFoundException  | SQLException e)
		{
			 e.printStackTrace();	
		}
		return null;
	}
}
