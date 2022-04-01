package com.lnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.entity.Admin;
import com.lnt.entity.Product;
import com.lnt.entity.Retailer;
import com.lnt.dto.AdminLoginDto;
import com.lnt.dto.LoginDto;
import com.lnt.service.AdminService;
import com.lnt.service.ProductService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	ProductService productService;

	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody  Admin admin) {
		return adminService.addAdmin(admin);
		
	}
	
	@PostMapping("/loginAdmin")
	public Admin adminLogin(@RequestBody AdminLoginDto logindto) {
		Admin admin=adminService.loginAdmin(logindto.getAdminId(), logindto.getAdminPassword());
		
		return admin;
	}
	
	@DeleteMapping(value="/deleteRetailer/{retailerId}")
	public void deleteRetailer( @PathVariable int retailerId) {
		adminService.deleteRetailer(retailerId);
		System.out.println("Retailer removed ");
	}
	
	@GetMapping(value = "/approveProduct/{productId}")
	public Product approveProduct(@PathVariable int productId) {
		Product product =productService.findProductFindById(productId);
		Product p=adminService.approveProduct(product);
		return p;
	}
	
}
	


