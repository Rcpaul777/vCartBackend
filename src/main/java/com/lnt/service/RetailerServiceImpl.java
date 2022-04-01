package com.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.dao.RetailerDao;
import com.lnt.entity.Product;
import com.lnt.entity.Retailer;

@Service
public class RetailerServiceImpl implements RetailerService {

	@Autowired
	RetailerDao retailerDao;

	@Override
	public Retailer addorUpdateRetailer(Retailer retailer) {
		return retailerDao.addorUpdateRetailer(retailer);
	}

	@Override
	public Retailer findRetailerById(int retailerId) {
		return retailerDao.findRetailerById(retailerId);
	}

	@Override
	public List<Retailer> viewAllRetailers() {
		return retailerDao.viewAllRetailers();
	}

	@Override
	public Product addProductByRetailer(Product product) {
		return retailerDao.addProductByRetailer(product);
	}

	@Override
	public List<Product> displayRetailerProducts(int retailerId) {
		return retailerDao.displayRetailerProducts(retailerId);
	}

	@Override
	public Retailer retailerLogin(String email, String password) {
		return retailerDao.retailerLogin(email, password);
	}

}
