package com.lnt.entity;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="shop_order")
public class Order {
	
	@Id
	@SequenceGenerator(name = "ord_seq", initialValue = 4550, allocationSize = 1)
	@GeneratedValue(generator = "ord_seq", strategy = GenerationType.SEQUENCE)
	int orderId;
	
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	Cart cart;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public  Order() {
		
	}

	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	

}
