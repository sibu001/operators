package com.springjpa.ebms.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private int id;
	@Range(min = 0, max = 9999)
	@NotNull(message = "meter number can not be null")
	private Integer meter;
	@NotEmpty(message = "name is mendatory")
	private String name;
	@NotEmpty(message = "address is mendatory")
	private String address;
	@NotEmpty(message = "state can not be null")
	private String state;
	@NotEmpty
	@Pattern(regexp = "^[0-9]{10}$", message = "please!! phone number must be of 10 digit")
	private String phone_no;
    @javax.validation.constraints.Email
	private String emailId;
    private String password;

}
