package com.allianz.shopping.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
	private int id;
	private String code;
	private String description;
	private float price;
	private Date manfDate;
	private List<Category> categoryList=new ArrayList<Category>();

	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public int getId() {
		return id;
	}
	public Product() {
		super();
		this.id = 0;
		this.code = null;
		this.description = null;
		this.price = 0.0f;
		this.manfDate = null;
	}

	public Product(int id, String code, String description, float price, Date manfDate) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.price = price;
		this.manfDate = manfDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getManfDate() {
		return manfDate;
	}

	public void setManfDate(Date manfDate) {
		this.manfDate = manfDate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", description=" + description + ", price=" + price
				+ ", manfDate=" + manfDate + "]";
	}



}
