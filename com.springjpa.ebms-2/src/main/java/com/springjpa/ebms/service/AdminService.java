package com.springjpa.ebms.service;

import java.util.List;

import com.springjpa.ebms.dto.BillingDto;
import com.springjpa.ebms.dto.CustomerDto;
import com.springjpa.ebms.entity.Billing;

public interface AdminService {
	  CustomerDto updateCustomer(CustomerDto customerDto,Integer meter_no);
	  CustomerDto getCustomerBymeter_no(Integer meter_no);
      List<CustomerDto> getAllCustomer();
      void deleteCustomer(Integer meter_no);
     
}
