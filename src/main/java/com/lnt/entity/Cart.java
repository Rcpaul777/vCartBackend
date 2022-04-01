package com.lnt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shop_cart")
public class Cart {

	@Id
	@SequenceGenerator(name = "crt_seq", initialValue = 7300, allocationSize = 1)
	@GeneratedValue(generator = "crt_seq", strategy = GenerationType.SEQUENCE)
	int cartId;

	@OneToOne
	@JoinColumn(name = "customer_Id")
	Customer customer;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	List<Order> orders;

	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	List<CartProduct> cartproduct;

	public List<CartProduct> getCartproduct() {
		return cartproduct;
	}

	public void setCartproduct(List<CartProduct> cartproduct) {
		this.cartproduct = cartproduct;
	}

	public Cart() {

	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Cart(int cartId, int customerid) {
		super();
		this.cartId = cartId;

	}
	@JsonIgnore
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
