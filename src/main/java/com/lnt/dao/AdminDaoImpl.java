package com.lnt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lnt.entity.Admin;
import com.lnt.entity.Product;
import com.lnt.entity.Retailer;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Admin addAdmin(Admin admin) {
		Admin a = em.merge(admin);
		return a;
	}

	@Transactional
	public Admin loginAdmin(long adminId, String adminPassword) {

		
		try {
			String jpql = "select a from Admin a where a.adminId=:uid and a.adminPassword=:pwd";
			TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
			query.setParameter("uid", adminId);
			query.setParameter("pwd", adminPassword);
			Admin admin = query.getSingleResult();
			System.out.println("yes ");
			return admin;
			}catch (Exception e) {
				return null;
			}
		}
	

	@Transactional
	public Retailer approveRetailer(Retailer retailer) {
		retailer.setStatus(true);
		Retailer r = em.merge(retailer);
		return r;
	}

	@Transactional
	public Product approveProduct(Product product) {
		product.setApproved(true);
		product.getCategoryName();
		Product p = em.merge(product);
		return p;
	}

	@Transactional
	public Retailer deleteRetailer(int retailerId) {
		Retailer r = em.find(Retailer.class, retailerId);
		em.remove(r);
		return r;
	}

	@Transactional
	public List<Retailer> fetcRetailerNotApproved() {
		String jpql = "select p from Retailer p where status=0";
		Query query = em.createQuery(jpql);
		List<Retailer> p = query.getResultList();
		return p;
	}

	@Transactional
	public List<Product> fetcProductNotApproved() {
		String jpql = "select p from Product p where approved=0";
		Query query = em.createQuery(jpql);
		List<Product> p = query.getResultList();
		return p;
	}

}
