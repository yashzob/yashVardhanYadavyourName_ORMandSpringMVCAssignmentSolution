package com.CustomerMgmt.Relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerMgmt.Relation.model.Customer;
import com.CustomerMgmt.Relation.repo.CustomerRepo;


@Service
public class CustomerServiceImplemenattion implements CustomerService{
	@Autowired
	CustomerRepo customerRepo;
	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepo.findAll();
	}

	@Override
	public void save(Customer customer) {
		customerRepo.save(customer);
		
	}

	@Override
	public void deleteById(Integer Id) {
		customerRepo.deleteById(Id);;
		
	}

	@Override
	public Optional<Customer> getCustomerById(Integer Id) {
		
		return customerRepo.findById(Id);
	}

	@Override
	public Optional<Customer> findById(Integer Id) {
		return customerRepo.findById(Id);
	}

	@Override
	public List<Customer> search(String firstName) {
		
		return customerRepo.findByFirstName(firstName);
	}

}
