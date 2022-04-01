package com.lnt.dao;

import java.util.List;

import com.lnt.entity.Admin;
import com.lnt.entity.Product;
import com.lnt.entity.Retailer;

public interface AdminDao {
	
	 Admin addAdmin(Admin admin);
	 Admin loginAdmin(long adminId, String password);
	 Retailer approveRetailer(Retailer retailer);
	 Product approveProduct(Product product);
	 Retailer deleteRetailer(int retailerId);
	 List<Retailer> fetcRetailerNotApproved();
	 List<Product> fetcProductNotApproved();
	 
	 

}
