package com.cg.MVC.repo;

import com.cg.MVC.bean.Customer;

public interface ICustomerRepository {
public Customer addCustomer(Customer customer);
public Customer update(int id);
public Customer updateDetail(Customer customer);
}
