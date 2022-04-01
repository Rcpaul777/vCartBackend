package com.lnt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lnt.entity.CartProduct;
import com.lnt.entity.Retailer;
import com.lnt.entity.Product;


@Repository
public class CartProductImpl implements CartProductDao {
	
	@PersistenceContext
	EntityManager em;

	@Transactional
	public CartProduct addProductInCartProduct(CartProduct cartproducts) {
		CartProduct it = em.merge(cartproducts);
		return it;
	}

	@Override
	public CartProduct removeProductFromCartProduct(CartProduct cartproducts) {
		CartProduct it = em.find(CartProduct.class, cartproducts);
		em.remove(it);
		return it;
		
	
	}

}
