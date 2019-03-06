package com.cg.MVC.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.MVC.bean.Customer;

@Repository("repo")
public class CustomerRepositoryImpl implements ICustomerRepository{
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		entityManager.flush();
		return customer;
	}

	@Override
	public Customer update(int id) {
		Customer c1=entityManager.find(Customer.class,id);
		if(c1==null) {
			return null;
		}
		return c1;
	}

}
