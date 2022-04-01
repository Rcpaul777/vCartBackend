package com.lnt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lnt.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	EntityManager em;


	@Transactional
	public Customer addOrUpdateCustomer(Customer customer) {
		Customer u = em.merge(customer);
		return u;

	}

	@Transactional
	public List<Customer> viewAllCustomers() {
		String jpql = "select c from Customer c";
		Query query = em.createQuery(jpql, Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;

	}

	
	@Transactional
	public Customer findCustomerById(int customerId) {
		return em.find(Customer.class, customerId);

	}


	@Transactional
	public Customer loginCustomer(String emailId, String password) {

		
		try {
			String jpql = "select c from Customer c where c.customerEmailId=:uid and c.customerPassword=:pwd";
			TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
			query.setParameter("uid", emailId);
			query.setParameter("pwd", password);
			Customer customer = query.getSingleResult();
			System.out.println("yes ");
			return customer;
			}catch (Exception e) {
				return null;
			}
		}

}
