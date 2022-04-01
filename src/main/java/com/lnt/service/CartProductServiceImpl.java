package com.lnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.dao.CartProductDao;
import com.lnt.entity.CartProduct;
@Service
public class CartProductServiceImpl implements CartProductService {
	@Autowired
	CartProductDao cartProductdao;

	@Override
	public CartProduct addProductInCartProduct(CartProduct cartproducts) {
		return cartProductdao.addProductInCartProduct(cartproducts);
	}

	@Override
	public CartProduct removeProductFromCartProduct(CartProduct cartproducts) {
		return cartProductdao.removeProductFromCartProduct(cartproducts);
	}

}
