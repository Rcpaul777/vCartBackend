package com.lnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.dao.CartDao;
import com.lnt.entity.Cart;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartDao cartDao;

	@Override
	public Cart addCart(Cart cart) {
		return cartDao.addCart(cart);
		
	}

	@Override
	public Cart findCartbyCartId(int cartId) {
		return cartDao.findCartbyCartId(cartId);
	}

}
