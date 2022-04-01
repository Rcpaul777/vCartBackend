package com.lnt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lnt.entity.Product;

@Repository

public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	EntityManager em;

	

	@Override
	@Transactional
	public Product findProductFindById(int productId) {
		Product product= new Product();
		product= em.find(Product.class, productId);
		return product;
	}

	@Override
	@Transactional
	public Product removeProduct(int productId) {

		Product p = em.find(Product.class, productId);
		em.remove(p);
		return p;
	
		
	}

	@Override
	@Transactional
	public Product findProductByName(String name) {
		String jpql = "select p from Product p where productName=:pName";
		Query query = em.createQuery(jpql);
		query.setParameter("pName", name);
		Product p = (Product) query.getSingleResult();
		return p;
	}

	@Override
	@Transactional
	public List<Product> filterByBrand(String brand) {
		String jpql = "select p from Product p where p.brand=:brandName";
		Query query = em.createQuery(jpql);
		query.setParameter("brandName", brand);
		List<Product> prod = query.getResultList();
		return prod;
	}

	@Override
	@Transactional
	public List<Product> filterByProductPrice(double minPrice, double maxPrice) {
		String jpql = "select p from Product p where p.productPrice between :minPrice AND :maxPrice ";
		Query query = em.createQuery(jpql);
		query.setParameter("minPrice", minPrice);
		query.setParameter("maxPrice", maxPrice);
		List<Product> prod = query.getResultList();
		return prod;
	
		
	}
	
	@Transactional
	public List<Product> viewAllProducts(){
		String jpql = "select p from Product p";
		Query query = em.createQuery(jpql, Product.class);
		List<Product> product = query.getResultList();
		return product;
	}

}
