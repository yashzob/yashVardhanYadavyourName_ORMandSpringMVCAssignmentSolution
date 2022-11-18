package com.CustomerMgmt.Relation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CustomerMgmt.Relation.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	public List<Customer> findByFirstName(String firstName);

}
