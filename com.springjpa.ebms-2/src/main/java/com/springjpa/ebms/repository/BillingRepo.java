package com.springjpa.ebms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springjpa.ebms.entity.Billing;
import com.springjpa.ebms.entity.Customer;

public interface BillingRepo extends JpaRepository<Billing, Integer> {
	 List<Billing> findByCustomer(Customer customer);
	
}
