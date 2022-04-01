package com.lnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.entity.Cart;
import com.lnt.entity.Customer;
import com.lnt.service.CartService;
import com.lnt.service.CustomerService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/addCart/{customerId}", method = RequestMethod.POST)
	public Cart addCart(@RequestBody Cart cart, @PathVariable int customerId) {
		Customer customer = customerService.findCustomerById(customerId);
		cart.setCustomer(customer);
		return cartService.addCart(cart);
	}

	@RequestMapping("/findCartById/{cartId}")
	public Cart findRetailerById(@PathVariable("cartId") int cartId) {

		return cartService.findCartbyCartId(cartId);
	}

}
