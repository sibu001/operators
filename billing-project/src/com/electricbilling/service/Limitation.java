package com.electricbilling.service;

import com.electricbilling.dao.*;
import com.electricitybilling.entity.CEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Limitation {
public static boolean pattern(String phone_no) {
	String str = "" + phone_no;
	String syntax = "^[0-9]{10}$";
	Pattern ptrn = Pattern.compile(syntax);  
	Matcher match = ptrn.matcher(str); 
	match.matches();
	return (match.matches());
}
public	static boolean meter(int meter_no) {
	String str = "" + meter_no;
	String syntax = "^[0-9]{5}$";
	Pattern ptrn = Pattern.compile(syntax);  
	Matcher match = ptrn.matcher(str); 
	match.matches();
	return (match.matches());
	
}
public static void check(CEntity en) throws IOException, Exception {
if(Limitation.pattern(en.getPhone_no()) && Limitation.meter(en.getMeter_no())) {
	new AdminproDao().prodao(en);
}
else {
	System.out.println("invalid mobile number or meter number");
     }  
	
}
}
