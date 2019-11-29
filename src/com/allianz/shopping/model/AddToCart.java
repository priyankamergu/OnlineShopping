package com.allianz.shopping.model;

public class AddToCart
{
	private int add_To_Cart_id;
	private int order_id;
	private int product_id;
	private float total;
	private int quantity;
	public AddToCart()
	{
		this.add_To_Cart_id = 0;
		this.order_id = 0;
		this.product_id = 0;
		this.quantity = 0;
	}
	
	
	public AddToCart(int add_To_Cart_id, int order_id, int product_id, int quantity) {
		super();
		this.add_To_Cart_id = add_To_Cart_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public int getAdd_To_Cart_id() {
		return add_To_Cart_id;
	}
	public void setAdd_To_Cart_id(int add_To_Cart_id) {
		this.add_To_Cart_id = add_To_Cart_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "AddToCart [add_To_Cart_id=" + add_To_Cart_id + ", order_id=" + order_id + ", product_id=" + product_id
				+ ", total=" + total + ", quantity=" + quantity + "]";
	}
	
}
