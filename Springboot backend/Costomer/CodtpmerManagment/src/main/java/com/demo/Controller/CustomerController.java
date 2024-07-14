package com.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.product.Customer;
import com.demo.service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	
//	find All
	
	@GetMapping("/findAllCustomers")
    public ResponseEntity<List<Customer>> findAllCustomers() {
        List<Customer> customers = cs.FindAllCustomer();

        // Check if customers is empty
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content
        } else {
            return ResponseEntity.ok(customers); // Return 200 OK with customers list
        }
    }
	
//	find by iD
	@GetMapping("/findById/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) {
        Customer customer = cs.findById(customerId);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        
//        Insert With Customer
    }
	@PostMapping("/AddCustomer")
	public ResponseEntity<Customer> AddCustomer(@RequestBody Customer customer) {
		Customer saveCustomer = cs.SaveCostomer(customer);
		
		if(saveCustomer!=null)
		{
			return ResponseEntity.ok(saveCustomer);
		}
		else {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
//	update customer
	
	@PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer updatedCustomer = cs.saveCustomer(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
	
	
	
//	Delete  CUSTOMER
	
	 @DeleteMapping("/deleteById/{customerId}")
	    public ResponseEntity<String> deleteCustomerById(@PathVariable int customerId) {
	        int result = cs.deleteById(customerId);
	        if (result == 1) {
	            return ResponseEntity.ok("Customer deleted successfully");
	        } else if (result == 0) {
	            return ResponseEntity.notFound().build(); // Customer not found
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body("Error deleting customer with ID: " + customerId);
	        }
	    }
	
	}

