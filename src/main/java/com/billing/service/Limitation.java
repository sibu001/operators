package com.billing.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Limitation {
public static boolean pattern(String phone_no) {
	String str = "" + phone_no;
	String syntax = "^[0-9]{10}$";
	Pattern ptrn = Pattern.compile(syntax);  
	Matcher match = ptrn.matcher(str); 
	match.matches();
	if( (match.matches())) {
		return true;
	}
	else {
		return false;
	}
}
public	static boolean meter(int meter_no) {
	String str = "" + meter_no;
	String syntax = "^[0-9]{5}$";
	Pattern ptrn = Pattern.compile(syntax);  
	Matcher match = ptrn.matcher(str); 
	match.matches();
	if ((match.matches())) {
		return true;
	}
	else {
		return false;
	}
	
}
//public static void check(Cdata c) throws IOException, Exception {
//if(Limitation.pattern(c.getPhone_no()) && Limitation.meter(c.getMeter_no())) {
//	
//}
//else {
//	System.out.println("invalid mobile number or meter number");
//     }  
//	
//}
}
