package com.lnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.entity.Admin;
import com.lnt.entity.Customer;
import com.lnt.dto.CustomerLoginDto;
import com.lnt.dto.Status;
import com.lnt.dto.Status.StatusType;
import com.lnt.service.CustomerService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public Status addOrUpdateCustomer(@RequestBody Customer customer) {
		
		String message;
		Status status=new Status();
		try {
			message=customerService.addOrUpdateCustomer(customer);
			status.setMessage(message);
			status.setStatus(StatusType.SUCCESS);
			return status;
		}catch (Exception e) {
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);
			return status;
		}
	} 
	
	@RequestMapping("/viewAllCustomers")
	public List<Customer> viewAllCustomers()  {
		return customerService.viewAllCustomers();
	}

	@RequestMapping("/findCustomerById/{customerId}")
	 public Customer findCustomerById(  @PathVariable("customerId") int customerId) {
		return customerService.findCustomerById(customerId);
	 }
	
	@PostMapping("/loginCustomer")
	public Customer loginCustomer(@RequestBody CustomerLoginDto customerDto) {
		Customer customer=customerService.loginCustomer(customerDto.getCustomerEmailId(), customerDto.getCustomerPassword());
		return  customer;
	}
	
}
