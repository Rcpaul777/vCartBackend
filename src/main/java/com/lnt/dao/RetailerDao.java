package com.lnt.dao;

import java.util.List;

import com.lnt.entity.Product;
import com.lnt.entity.Retailer;

public interface RetailerDao {
	
	Retailer addorUpdateRetailer(Retailer retailer);
	Retailer findRetailerById(int retailerId);
	List<Retailer> viewAllRetailers();
	Product addProductByRetailer(Product product);
	List<Product> displayRetailerProducts(int retailerId);
	Retailer retailerLogin(String email, String password);
}
