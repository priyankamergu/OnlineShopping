package com.allianz.shopping.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtility
{
	public static Date convertStringToDate(String date)  
	{
		SimpleDateFormat simple=new SimpleDateFormat("dd/mm/yyyy");
		try
		{
			Date dateLocal=simple.parse(date);
			return dateLocal;
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String convertDateToString(Date date)
	{
		SimpleDateFormat simple=new SimpleDateFormat("dd/mm/yyyy");
		
		try
		{
			String dateLocal=simple.format(date);
			return dateLocal;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public static java.sql.Date convertUtilDateToSQLDate(java.util.Date date)
	{
		java.sql.Date sdate=new java.sql.Date(date.getTime());
		return sdate;
	}
	
	
}
