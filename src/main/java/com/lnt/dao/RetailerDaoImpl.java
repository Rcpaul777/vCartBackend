package com.lnt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lnt.entity.Product;
import com.lnt.entity.Retailer;

@Repository
public class RetailerDaoImpl implements RetailerDao {
	@PersistenceContext
	EntityManager em;

	@Transactional

	public Retailer addorUpdateRetailer(Retailer retailer) {

		Retailer r = em.merge(retailer);

		return r;
	}

	@Transactional
	public Retailer findRetailerById(int retailerId) {
		return em.find(Retailer.class, retailerId);
	}

	@Transactional
	public List<Retailer> viewAllRetailers() {
		String jpql = "select r from Retailer r";
		Query query = em.createQuery(jpql, Retailer.class);
		List<Retailer> l = query.getResultList();
		return l;
	}

	@Transactional
	public Product addProductByRetailer(Product product) {

		Product p = em.merge(product);

		return p;
	}

	@Transactional
	public List<Product> displayRetailerProducts(int retailerId) {
		Retailer r = em.find(Retailer.class, retailerId);
		List<Product> listOfProducts = r.getProduct();
		return listOfProducts;

	}

	@Transactional
	public Retailer retailerLogin(String emailId, String password) {

		try {
			String jpql = "select r from Retailer r where r.emailId=:uid and r.password=:pwd";
			TypedQuery<Retailer> query = em.createQuery(jpql, Retailer.class);
			query.setParameter("uid", emailId);
			query.setParameter("pwd", password);
			Retailer retailer = query.getSingleResult();
			return retailer;
		} catch (Exception e) {
			return null;
		}
	}
}
