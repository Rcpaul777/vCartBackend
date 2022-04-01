package com.lnt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lnt.entity.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public Cart addCart(Cart cart) {
		Cart c1 = em.merge(cart);

		return c1;

	}

	@Transactional
	public Cart findCartbyCartId(int cartId) {
		Cart c = em.find(Cart.class, cartId);
		return c;
	}

}
