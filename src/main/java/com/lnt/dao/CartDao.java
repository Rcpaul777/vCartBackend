package com.lnt.dao;

import com.lnt.entity.Cart;

public interface CartDao {
	
	Cart addCart(Cart cart);
	Cart findCartbyCartId(int cartId);

}
