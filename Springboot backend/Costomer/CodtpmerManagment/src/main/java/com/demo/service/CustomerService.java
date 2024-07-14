package com.demo.service;

import java.util.List;

import com.demo.product.Customer;

public interface CustomerService {
	
	public List<Customer>FindAllCustomer();
	Customer findById(int CoustomerId);
	public Customer SaveCostomer (Customer customer);
		public Customer saveCustomer(Customer c);
		 public int deleteById(int customerId);
	
		
	
}
