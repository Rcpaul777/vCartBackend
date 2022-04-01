package com.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.dao.AdminDao;
import com.lnt.entity.Admin;
import com.lnt.entity.Product;
import com.lnt.entity.Retailer;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	
	public Admin loginAdmin(long adminId, String password) {
		return adminDao.loginAdmin(adminId, password);
	}

	@Override
	public Retailer approveRetailer(Retailer retailer) {
		return adminDao.approveRetailer(retailer);
	}

	@Override
	public Product approveProduct(Product product) {
		return adminDao.approveProduct(product);
	}

	@Override
	public Retailer deleteRetailer(int retailerId) {
		return adminDao.deleteRetailer(retailerId);
	}

	@Override
	public List<Retailer> fetcRetailerNotApproved() {
		return adminDao.fetcRetailerNotApproved();
	}

	@Override
	public List<Product> fetcProductNotApproved() {
		return adminDao.fetcProductNotApproved();
	}

}
