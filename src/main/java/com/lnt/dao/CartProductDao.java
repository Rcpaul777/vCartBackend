package com.lnt.dao;

import com.lnt.entity.CartProduct;

public interface CartProductDao {
	CartProduct addProductInCartProduct(CartProduct cartproducts);
	CartProduct removeProductFromCartProduct(CartProduct cartproducts);

}
