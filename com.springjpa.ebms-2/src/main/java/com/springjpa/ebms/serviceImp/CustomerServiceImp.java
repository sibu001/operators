package com.springjpa.ebms.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springjpa.ebms.dto.BillingDto;
import com.springjpa.ebms.dto.CustomerDto;
import com.springjpa.ebms.entity.Billing;
import com.springjpa.ebms.entity.Customer;
import com.springjpa.ebms.entity.Role;
import com.springjpa.ebms.exception.ResourceNotFoundException;
import com.springjpa.ebms.repository.BillingRepo;
import com.springjpa.ebms.repository.CustomerRepo;
import com.springjpa.ebms.repository.RoleRepo;
import com.springjpa.ebms.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	public BillingRepo billingRepo;

	@Autowired
	public CustomerRepo customerRepo;

	@Autowired
	public ModelMapper modelMapper;
	@Autowired
	public RoleRepo roleRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer = this.modelMapper.map(customerDto, Customer.class);
		customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
		Customer customer2 = this.customerRepo.save(customer);
		return this.modelMapper.map(customer2, CustomerDto.class);

	}

	public Customer DtoToEntity(CustomerDto customerdto) {
		Customer customer = this.modelMapper.map(customerdto, Customer.class);
		return customer;
	}

	public CustomerDto EntityToDto(Customer customer) {
		CustomerDto customerDto = this.modelMapper.map(customer, CustomerDto.class);
		return customerDto;
	}

	@Override
	public BillingDto payment(BillingDto billingDto, Integer meter) {
		Customer customer = this.customerRepo.findByMeter(meter)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer_meter_no", meter));
		Billing billing = this.modelMapper.map(billingDto, Billing.class);
		billing.setDate(new Date());
		billing.setCustomer(customer);
		double amount = this.getbillamount(billingDto.getUnit());
		billing.setAmount(amount);
		Billing billing2 = this.billingRepo.save(billing);
		System.out.println(modelMapper.map(billing2, BillingDto.class));
		return this.modelMapper.map(billing2, BillingDto.class);
	}

	public double getbillamount(int unit) {
		double billToPay = 0;
		if (unit <= 100) {
			billToPay = unit * 4.40;
		}

		else if (unit <= 300) {
			billToPay = 100 * 4.40 + (unit - 100) * 2;
		}

		else if (unit > 300) {
			billToPay = 100 * 4.40 + 200 * 2 + (unit - 300) * 3;
		}

		return billToPay;
	}

// getbillByCustomer_meter
	@Override
	public List<BillingDto> getBillByMeter(Integer meter_no) {
		Customer customer = this.customerRepo.findByMeter(meter_no)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer_meter_no", meter_no));
		List<Billing> bill = this.billingRepo.findByCustomer(customer);
		List<BillingDto> collect = bill.stream().map((Billing) -> this.modelMapper.map(Billing, BillingDto.class))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public Role saveRole(Role role) {

		return this.roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String email, String role) {
		Customer findByEmail = this.customerRepo.FindByEmail(email);
		Role findByName = this.roleRepo.FindByName(role);
		List<Role> roles = new ArrayList<>();
		roles.add(findByName);
		findByEmail.setRole(roles);
		this.customerRepo.save(findByEmail);

	}

}
