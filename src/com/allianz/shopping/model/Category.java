package com.allianz.shopping.model;

public class Category 
{
	private int categoryId;
	private String categoryCode;
	private String categoryDescription;
	
	public Category()
	{
		this.categoryId = 0;
		this.categoryCode = null;
		this.categoryDescription = null;
	}
	public Category(int categoryId, String categoryCode, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryCode = categoryCode;
		this.categoryDescription = categoryDescription;
	}
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	public String getCategoryCode()
	{
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode)
	{
		this.categoryCode = categoryCode;
	}
	public String getCategoryDescription()
	{
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription)
	{
		this.categoryDescription = categoryDescription;
	}
	@Override
	public String toString() 
	{
		return "Category [categoryId=" + categoryId + ", categoryCode=" + categoryCode + ", categoryDescription="
				+ categoryDescription + "]";
	}
	
}
