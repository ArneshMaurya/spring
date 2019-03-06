package com.cg.MVC.service;

import com.cg.MVC.bean.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer update(int id) ;
	public Customer updateDetail(Customer customer);
}
