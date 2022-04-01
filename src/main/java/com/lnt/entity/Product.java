package com.lnt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="shop_product")
public class Product {

@Id
@SequenceGenerator(name="product_seq",initialValue=8001,allocationSize=1)
@GeneratedValue(generator="product_seq",strategy=GenerationType.SEQUENCE)
	int proudctId;
	
	String productName;
	int stock;
	String categoryName;
	double productPrice;
	String brand;
	String descriptio;
	boolean approved;
	
	
	public boolean isApproved() {
		return approved;
	}




	public void setApproved(boolean b) {
		this.approved = b;
	}




	public String getDescriptio() {
		return descriptio;
	}




	public void setDescriptio(String descriptio) {
		this.descriptio = descriptio;
	}
	
	
	@ManyToOne
	@JoinColumn(name="retailer_Id")
	Retailer retailer;



	public Retailer getRetailer() {
		return retailer;
	}




	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}




	public Product() {
		
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


	

}
