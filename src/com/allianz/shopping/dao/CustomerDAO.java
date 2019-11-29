package com.allianz.shopping.dao;

import com.allianz.shopping.model.Customer;

public interface CustomerDAO 
{
	public boolean validate(String uname,String pass);
	public boolean registeration(Customer customer);
	
}
