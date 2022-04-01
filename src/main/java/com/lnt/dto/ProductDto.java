package com.lnt.dto;

public class ProductDto {
	
	int proudctId;
	
	String productName;
	int stock;
	String categoryName;
	double productPrice;
	String brand;
	boolean approved;
	String descriptio;
	public String getDescriptio() {
		return descriptio;
	}
	public void setDescriptio(String descriptio) {
		this.descriptio = descriptio;
	}
	public int getProudctId() {
		return proudctId;
	}
	public void setProudctId(int proudctId) {
		this.proudctId = proudctId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
	

}
