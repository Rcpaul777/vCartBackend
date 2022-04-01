package com.lnt.dao;

import java.util.List;

import com.lnt.entity.Product;

public interface ProductDao {
	
	
	
	Product findProductFindById(int productId);

	Product removeProduct(int productId);

	Product findProductByName(String name);

	List<Product> filterByBrand(String brand);

	List<Product> filterByProductPrice(double minPrice, double maxPrice);
	
	List<Product> viewAllProducts();

}
