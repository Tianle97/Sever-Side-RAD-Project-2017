package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.repositories.CustomerInterface;

@Service
public class CustomerService {

@Autowired
	private CustomerInterface customerinterface;

public ArrayList<Customer> getCustomer() {
	
	ArrayList<Customer> c = (ArrayList<Customer>) customerinterface.findAll();
	return c;
	
}
public Customer save(Customer c1) {
	customerinterface.save(c1);
	return customerinterface.save(c1);
}
}
