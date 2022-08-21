package com.springjpa.ebms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springjpa.ebms.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	@Query(value = "select * from Customer_records where customer_meter_num=?", nativeQuery = true)
	Optional<Customer> findByMeter(int meter);
	@Query(value="select*from Customer_records where email_id=?", nativeQuery = true)
	Customer FindByEmail(String email);
}
