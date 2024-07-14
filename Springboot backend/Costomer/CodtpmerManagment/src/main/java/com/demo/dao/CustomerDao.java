package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.product.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
