package com.springjpa.ebms.service;

import java.util.List;

import com.springjpa.ebms.dto.BillingDto;
import com.springjpa.ebms.dto.CustomerDto;
import com.springjpa.ebms.entity.Role;

public interface CustomerService {
	public CustomerDto createCustomer(CustomerDto customerDto);
	public BillingDto  payment(BillingDto billingDto,Integer CustomerMeter_no);
	public List<BillingDto> getBillByMeter(Integer meter_no);
	public Role saveRole(Role role );
	public void addRoleToUser(String email,String role);
}
