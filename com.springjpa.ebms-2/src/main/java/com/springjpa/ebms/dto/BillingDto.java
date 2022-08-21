package com.springjpa.ebms.dto;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.springjpa.ebms.entity.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class BillingDto {
	
	int meter_id;
	Date date;
	//@Range(min = 0, max = 9999,message = "meter number is between 0 to 9999")
	//int meter_no;
	@NotNull(message = "please enter unit of power consume")
	int unit;
	double amount;
//	private Customer customer;
	private CustomerDto customer;
}
