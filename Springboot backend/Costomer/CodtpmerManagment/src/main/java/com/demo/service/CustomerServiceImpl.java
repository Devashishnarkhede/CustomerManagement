package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.demo.dao.CustomerDao;
import com.demo.product.Customer;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao cd;

	@Override
	public List<Customer> FindAllCustomer() {
		List<Customer>findAll = cd.findAll();
		return findAll;
	}

	 @Override
	    public Customer findById(int customerId) {
	        Optional<Customer> optionalCustomer = cd.findById(customerId);
	        return optionalCustomer.orElse(null); // or handle the absence of customer as needed
	    }

	@Override
	public Customer SaveCostomer(Customer customer) {
		return cd.save(customer);
	}

	@Override
	public Customer saveCustomer(Customer c) {
		return cd.save(c); 
		
	}

	 public int deleteById(int customerId) {
	        try {
	            cd.deleteById(customerId);
	            return 1; // Return 1 indicating success
	        } catch (EmptyResultDataAccessException ex) {
	        	return 0;
	        } catch (Exception ex) {
	            throw new RuntimeException("Error deleting customer with ID: " + customerId, ex);
	        }
	    }


	
	}

	
	

