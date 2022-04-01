package com.lnt.service;

import com.lnt.entity.Cart;

public interface CartService {
	
	Cart addCart(Cart cart);
	Cart findCartbyCartId(int cartId);

}
