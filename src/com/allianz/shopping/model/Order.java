package com.allianz.shopping.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order
{
	private int order_id;
	private  Date date;
	private String oredr_status;
	private String userName;
	private float price;
	
	List<AddToCart> add_to_cart=new ArrayList<AddToCart>();
	
	
	public Order()
	{
		this.order_id = 0;
		this.date = null;
		this.oredr_status = null;
		this.userName =  null;
		this.price = 0.0f;
	}
	public Order(int order_id, Date date, String oredr_status, String userName, float price) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.oredr_status = oredr_status;
		this.userName = userName;
		this.price = price;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOredr_status() {
		return oredr_status;
	}
	public void setOredr_status(String oredr_status) {
		this.oredr_status = oredr_status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", Date=" + date + ", oredr_status=" + oredr_status + ", UserName="
				+ userName + ", price=" + price + "]";
	}
	public List<AddToCart> getAdd_to_cart() {
		return add_to_cart;
	}
	public void setAdd_to_cart(List<AddToCart> add_to_cart) {
		this.add_to_cart = add_to_cart;
	}
	
	
}
