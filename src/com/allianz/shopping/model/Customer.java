package com.allianz.shopping.model;

public class Customer
{
	int cust_id;
	String cust_name;
	String password;
	String username;
	int cust_mobile;
	
	
	public Customer()
	{
		this.cust_id = 0;
		this.cust_name = null;
		this.password = null;
		this.username = null;
		this.cust_mobile = 0;
	}
	
	
	public Customer(int cust_id, String cust_name, String password, String username, int cust_mobile) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.password = password;
		this.username = username;
		this.cust_mobile = cust_mobile;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(int cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	
}
