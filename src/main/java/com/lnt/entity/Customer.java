package com.lnt.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shop_customer")
public class Customer {
	
	@Id
	@SequenceGenerator(name = "seq_new_user", initialValue = 9000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_new_user")
	int customerId;
	String customerName;
	long customerMobNo;
	String customerEmailId;
	String customerPassword;
	
	public String getCustomerEmailId() {
		return customerEmailId;
	}


	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	


	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	Cart cart;
	
	@OneToMany(mappedBy = "customer")
	List<Order> order;
	
	

	public Customer() {

	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerMobNo() {
		return customerMobNo;
	}

	public void setCustomerMobNo(long customerMobNo) {
		this.customerMobNo = customerMobNo;
	}
	


	
	
	


	@JsonIgnore
	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}


	


}
