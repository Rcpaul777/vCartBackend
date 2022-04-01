package com.lnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.entity.Product;
import com.lnt.service.ProductService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/findProductByproductId/{productId}")
	Product findProductFindById(@PathVariable("productId")int productId) {
		return productService.findProductFindById(productId);
	}
	
	@DeleteMapping(value="/deleteproduct/{productId}")
	public void removeProductbyRetailer(@PathVariable int productId)
	{
		productService.removeProduct(productId);
		System.out.println();
	}
	
	@GetMapping(value="/productbyname/{productname}")
	public Product fetchProductbyProductbyName(@PathVariable String productname)
	{
		return productService.findProductByName(productname);
	}
	
	@GetMapping(value="/productbyBrandname/{brandName}")
	public List<Product> fetchProductbyBrandName(@PathVariable String brandName)	
	{
		return productService.filterByBrand(brandName);
	}
	
	@GetMapping("/filterByProductPrice/{minPrice}/{maxPrice}")
	public List<Product> filterByProductPrice(@PathVariable double minPrice,@PathVariable double maxPrice) {
		return productService.filterByProductPrice(minPrice, maxPrice);
		
	}
	
	@RequestMapping("/viewAllProducts")
	public List<Product> viewAllProducts(){
		return productService.viewAllProducts();
		
	}
	
}
