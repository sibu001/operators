package com.springjpa.ebms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.ebms.dto.ApiResponse;
import com.springjpa.ebms.dto.CustomerDto;
import com.springjpa.ebms.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	public AdminService adminService;

// update
	@PutMapping("/{customerMeter_no}")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,
			@PathVariable Integer customerMeter_no) {
		CustomerDto updateCustomer = this.adminService.updateCustomer(customerDto, customerMeter_no);
		return ResponseEntity.ok(updateCustomer);
	}

	// get single customer
	@GetMapping("/{meter_no}")
	public ResponseEntity<CustomerDto> getSingleCustomer(@PathVariable Integer meter_no) {
		return ResponseEntity.ok(this.adminService.getCustomerBymeter_no(meter_no));

	}

	// get all customer
	@GetMapping("/")
	public ResponseEntity<List<CustomerDto>> getAllCustomer() {
		return ResponseEntity.ok(this.adminService.getAllCustomer());
	}
	
	
	// delete customer

	@DeleteMapping("/{meter_no}")
	public ResponseEntity<com.springjpa.ebms.dto.ApiResponse> deleteUser(@PathVariable Integer meter_no) {
		this.adminService.deleteCustomer(meter_no);

		return new ResponseEntity(new ApiResponse("delete succesfully", true), HttpStatus.OK);

	}

}