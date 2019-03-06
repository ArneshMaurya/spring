package com.cg.MVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.MVC.bean.Customer;
import com.cg.MVC.repo.ICustomerRepository;
@Transactional
@Service("service")
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	ICustomerRepository repo;
	
	public ICustomerRepository getRepo() {
		return repo;
	}

	public void setRepo(ICustomerRepository repo) {
		this.repo = repo;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.addCustomer(customer);
	}

	@Override
	public Customer update(int id) {
		// TODO Auto-generated method stub
		return repo.update(id);
	}

	@Override
	public Customer updateDetail(Customer customer) {
		// TODO Auto-generated method stub
		return repo.updateDetail(customer);
	}

}
