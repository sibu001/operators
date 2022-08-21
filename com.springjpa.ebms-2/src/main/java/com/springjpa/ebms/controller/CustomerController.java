 package com.springjpa.ebms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.ebms.dto.BillingDto;
import com.springjpa.ebms.dto.CustomerDto;
import com.springjpa.ebms.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	public CustomerService customerService;

	@PostMapping("/")
	public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
		CustomerDto customerDto2 = this.customerService.createCustomer(customerDto);
		return new ResponseEntity<CustomerDto>(customerDto2, HttpStatus.CREATED);

	}

	@PostMapping("/Customer/{meter_no}/payments")
	public ResponseEntity<BillingDto> createPayment(@Valid @RequestBody BillingDto billingDto,
			@PathVariable Integer meter_no) {
		BillingDto payment = this.customerService.payment(billingDto, meter_no);
		return new ResponseEntity<BillingDto>(payment, HttpStatus.CREATED);

	}

	// getBillByCustomerid
	@GetMapping("/customer/{meter_no}/billing")
	public ResponseEntity<List<BillingDto>> getPostsByUser(@PathVariable Integer meter_no) {
		List<BillingDto> bill = this.customerService.getBillByMeter(meter_no);
		return new ResponseEntity<List<BillingDto>>(bill, HttpStatus.OK);

	}

}