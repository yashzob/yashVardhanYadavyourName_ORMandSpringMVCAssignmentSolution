package com.CustomerMgmt.Relation.service;

import java.util.List;
import java.util.Optional;

import com.CustomerMgmt.Relation.model.Customer;



public interface CustomerService {
	public List<Customer> getAllCustomer();
	public void save(Customer customer);
	public void deleteById(Integer Id);
	public Optional<Customer> getCustomerById(Integer Id);
	public Optional<Customer> findById(Integer Id);
	public List<Customer> search(String firstName);
}
