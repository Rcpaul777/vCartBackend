package com.lnt.dao;

import java.util.List;

import com.lnt.entity.Customer;

public interface CustomerDao {
	 Customer addOrUpdateCustomer(Customer customer);
	 List<Customer> viewAllCustomers();
	 Customer findCustomerById(int customerId);
	 Customer loginCustomer(String email, String password);
	 
	
	
	

}
