package com.lnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.entity.Product;
import com.lnt.entity.Retailer;
import com.lnt.dto.LoginDto;
import com.lnt.service.RetailerService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/retailers")
public class RetailerController {

	@Autowired
	RetailerService retailerService;

	@PostMapping("/addOrRetailer")
	public Retailer addRetailer(@RequestBody Retailer retailer) {
		return retailerService.addorUpdateRetailer(retailer);
	}

	@RequestMapping(value = "/addProductByRetailer/{retailerId}", method = RequestMethod.POST)
	public Product addProductByRetailer(@RequestBody Product product, @PathVariable int retailerId) {
		Retailer retailer = retailerService.findRetailerById(retailerId);
		product.setRetailer(retailer);
		return retailerService.addProductByRetailer(product);
	}

	@RequestMapping("/findRetailerById/{retailerId}")
	public Retailer findRetailerById(@PathVariable("retailerId") int retailerId) {
		return retailerService.findRetailerById(retailerId);
	}

	@RequestMapping("/viewAllRetailers")
	public List<Retailer> viewAllRetailers() {
		return retailerService.viewAllRetailers();
	}
	
	@RequestMapping("/loginRetailer")
	public Retailer retailerLogin(@RequestBody LoginDto logindto) {
		Retailer retailer =retailerService.retailerLogin(logindto.getEmailId(), logindto.getPassword());
		return retailer;
	}
	
	@GetMapping("/retailerProducts/{retailerId}")
	public List<Product> displayRetailerProducts(@PathVariable int retailerId) {
		return retailerService.displayRetailerProducts(retailerId);
	}

}
