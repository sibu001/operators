package com.springjpa.ebms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "billing_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int meter_id;
	@Column(name = "payment_date")
	Date date;
	
	//int meter_no;
	
	int unit;
	
	double amount;
	@ManyToOne
	private Customer customer;

}
