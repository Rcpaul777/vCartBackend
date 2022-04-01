package com.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.dao.ProductDao;
import com.lnt.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	

	public Product findProductFindById(int productId) {
		return productDao.findProductFindById(productId);
	}

	@Override
	public Product removeProduct(int productId) {
		return productDao.removeProduct(productId);
	}

	@Override
	public Product findProductByName(String name) {
		return productDao.findProductByName(name);
	}

	@Override
	public List<Product> filterByBrand(String brand) {
		return productDao.filterByBrand(brand);
	}

	@Override
	public List<Product> filterByProductPrice(double minPrice, double maxPrice) {
		return productDao.filterByProductPrice(minPrice, maxPrice);
		
	}
	
	public List<Product> viewAllProducts() {
		return productDao.viewAllProducts();
	}

}
