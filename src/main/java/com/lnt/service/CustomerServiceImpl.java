package com.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.dao.CustomerDao;
import com.lnt.dao.ProductDao;
import com.lnt.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	EmailService emailService;

	@Override
	public String addOrUpdateCustomer(Customer customer) {
		
		Customer persistedCustomer=customerDao.addOrUpdateCustomer(customer);
		int customerId=persistedCustomer.getCustomerId();
		System.out.println(customerId);
	
		String setTo=persistedCustomer.getCustomerEmailId();
		String subject="Registration Confirmation";
		String message="Congratulation "+persistedCustomer.getCustomerName()
		                                     +"!! Your userId is"+customerId;
		emailService.sendEmailForNewRegistration(setTo, message, subject);
		System.out.println("Email Sent.");
		
		return "Registration Successful. Please check your email";
		
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return customerDao.viewAllCustomers();
	}

	@Override
	public Customer findCustomerById(int customerId) {
		return customerDao.findCustomerById(customerId);
	}

	@Override
	public Customer loginCustomer(String email, String password) {
		return customerDao.loginCustomer(email, password);
	}
	

}
