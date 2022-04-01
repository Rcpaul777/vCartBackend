package com.lnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.entity.Cart;
import com.lnt.entity.CartProduct;
import com.lnt.entity.Product;
import com.lnt.service.CartProductService;
import com.lnt.service.CartService;
import com.lnt.service.ProductService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/cartProduct")
public class CartProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CartProductService cartProductService;
	@Autowired
	CartService cartService;
	
	@PostMapping(value="/addProductsToCart/{cartId}/{productId}")
	public CartProduct addProductsToCart(@RequestBody CartProduct cartProduct,@PathVariable int cartId,@PathVariable int productId) {
		
		Cart cid=cartService.findCartbyCartId(cartId);
		cartProduct.setCart(cid);
		Product product=productService.findProductFindById(productId);
		cartProduct.setProduct(product);
		return cartProductService.addProductInCartProduct(cartProduct);

	}
	
}
