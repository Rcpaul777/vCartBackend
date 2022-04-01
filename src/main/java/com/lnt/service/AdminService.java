package com.lnt.service;

import java.util.List;

import com.lnt.entity.Admin;
import com.lnt.entity.Product;
import com.lnt.entity.Retailer;

public interface AdminService {
	
	Admin addAdmin(Admin admin);
	 Admin loginAdmin(long string, String password);
	 Retailer approveRetailer(Retailer retailer);
	 Product approveProduct(Product product);
	 Retailer deleteRetailer(int retailerId);
	 List<Retailer> fetcRetailerNotApproved();
	 List<Product> fetcProductNotApproved();

}
