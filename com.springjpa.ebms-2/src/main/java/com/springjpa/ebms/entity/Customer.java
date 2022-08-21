package com.springjpa.ebms.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Customer_records")
@NoArgsConstructor
@Getter
@Setter

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NaturalId
	@Column(name = "customer_meterNum", unique = true)
	private Integer meter;
	@Column(name = "Customer_name", length = 100, nullable = false)
	private String name;
	@Column(name = "customer_address", length = 100)
	private String address;
	@Column(name = "customer_state")
	private String state;
	@Column(name = "customer_phoneNum", nullable = false)
	private String phone_no;
	@Email
	private String emailId;
	private String password;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	List<Billing> billing = new LinkedList();
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Role> role= new ArrayList<>();
	
	
	

	
	
	
	
	
	
	
}
