package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.AddToCart;

public interface AddToCartDAO 
{
	public boolean addToCart(AddToCart add);
	public List<AddToCart> getAllAddToCartByOrderId(int order_id);
}
