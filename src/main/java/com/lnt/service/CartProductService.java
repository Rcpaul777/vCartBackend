package com.lnt.service;

import com.lnt.dao.CartProductDao;
import com.lnt.entity.CartProduct;

public interface CartProductService {
	CartProduct addProductInCartProduct(CartProduct cartproducts);
	CartProduct removeProductFromCartProduct(CartProduct cartproducts);

}
