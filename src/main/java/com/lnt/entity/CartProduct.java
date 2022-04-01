package com.lnt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="shop_cartproduct")
public class CartProduct {
	
	@Id
	@SequenceGenerator(name = "cartproduct_seq", initialValue = 2550, allocationSize = 1)
	@GeneratedValue(generator = "cartproduct_seq", strategy = GenerationType.SEQUENCE)
	int cartProductId;
	
	int quantity;
	
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	Cart cart;
	
	@OneToOne
	@JoinColumn(name="product_id")
	Product product;
	
	

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartProduct() {
		
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


	
	
	
}
