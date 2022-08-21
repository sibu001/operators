package com.springjpa.ebms.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	String resourcename;
	String fieldname;
	int fieldvalue;
	public ResourceNotFoundException(String resourcename, String fieldname, int fieldvalue) {
		super(String.format("%s not found with %s:%s",resourcename,fieldname,fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
	
	
}