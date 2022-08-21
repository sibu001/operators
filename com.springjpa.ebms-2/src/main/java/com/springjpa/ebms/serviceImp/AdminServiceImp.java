package com.springjpa.ebms.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.ebms.dto.BillingDto;
import com.springjpa.ebms.dto.CustomerDto;
import com.springjpa.ebms.entity.Billing;
import com.springjpa.ebms.entity.Customer;
import com.springjpa.ebms.exception.ResourceNotFoundException;
import com.springjpa.ebms.repository.CustomerRepo;
import com.springjpa.ebms.service.AdminService;
@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	public CustomerRepo customerRepo;
	@Autowired
	public ModelMapper modelMapper;

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto, Integer meter_no) {
		Customer customer = this.customerRepo.findById(meter_no).orElseThrow(()-> new ResourceNotFoundException("Customer","meter_no", meter_no));
		customer.setAddress(customerDto.getAddress());
		customer.setEmailId(customerDto.getEmailId());
		customer.setMeter(customerDto.getMeter());
		customer.setName(customerDto.getName());
		customer.setPhone_no(customerDto.getPhone_no());
		customer.setState(customerDto.getState());
		Customer customer2 = this.customerRepo.save(customer);
		CustomerDto customer3= this.modelMapper.map(customer2, CustomerDto.class);
		return customer3;
		}
     @Override
	public CustomerDto getCustomerBymeter_no(Integer meter_no) {
		Optional<Customer> customer= this.customerRepo.findByMeter(meter_no);
		if(customer==null) {
			new ResourceNotFoundException("customer","meter_no",meter_no);
		}
		return this.modelMapper.map(customer, CustomerDto.class);
		
	}

	@Override
	public List<CustomerDto> getAllCustomer() {
		List<Customer> cudtomerlist = this.customerRepo.findAll();
		System.out.println(cudtomerlist);
		
		
		List<CustomerDto> collect = cudtomerlist.stream().map((customer)-> this.modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
		return collect;
		
	}

	@Override
	public void deleteCustomer(Integer meter_no) {
		Customer customer  = this.customerRepo.findById(meter_no).orElseThrow(()-> new ResourceNotFoundException("User","id",meter_no));
             this.customerRepo.delete(customer);
		
	}
	

}
