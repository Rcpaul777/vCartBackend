package com.lnt.service;

import java.util.List;

import com.lnt.entity.Customer;

public interface CustomerService {
	 String addOrUpdateCustomer(Customer customer);
	 List<Customer> viewAllCustomers();
	 Customer findCustomerById(int customerId);
	 Customer loginCustomer(String email, String password);
	

}
