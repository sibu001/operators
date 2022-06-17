package com.electricitybilling.controller;
import com.electricbilling.dao.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.electricbilling.service.Limitation;
import com.electricitybilling.entity.CEntity;

public class Coustmerprofile {
	public void profile() throws SQLException {
		try (Scanner in = new Scanner(System.in);) {
			
			while (true) {
				System.out.println("enter customer name");
				 String name= in.nextLine();
			        name+=in.nextLine();
				System.out.println("enter customer meter number");
				int meter_no = in.nextInt();
				System.out.println("enter customer address");
				String address = in.next();
				System.out.println("enter customer state ");
				String state = in.next();
				System.out.println("enter city");
				String city = in.next();
				System.out.println("enter phone number");
				String phone_no = in.next();
			    CEntity en = new CEntity();
				en.setName(name);
				en.setMeter_no(meter_no);
				en.setAddress(address);
				en.setState(state);
				en.setCity(city);
				en.setPhone_no(phone_no);
			    try {
					Limitation.check(en);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("DO YOU WANT ONE MORE RECORD(yes/no)");
				String option=in.next();
				if(option.equals("no")) {
					new Coustmercont().cust();
				}
	}
		}
}
	public void Cupdate() throws SQLException {
		try (Scanner in = new Scanner(System.in);) {

			System.out.println("enter meter number you want to update");
			int meter = in.nextInt();
			System.out.println("enter updated name");
			String name = in.next();
			System.out.println("enter updated adress");
			String address = in.next();
			System.out.println("enter updated state");
			String state = in.next();
			System.out.println("enter updated city");
			String city = in.next();
			System.out.println("enter updated phone number");
			String phone = in.next();
			new UpdateDao().Udao(name, meter, address, state, city, phone);
			System.out.println("do u want to update more (yes/no)");
			String choice = in.next();
			if (choice.equals("no")) {
				new Coustmercont().cust();
			}
		}	
	}
	public void bill() throws SQLException {
		double billToPay = 0;
		double amount;
		try(Scanner sc = new Scanner(System.in);){
		while (true) {
			System.out.println("enter valid month of bill ");
			String month = sc.next();
			System.out.println("enter meter number");
			int meter = sc.nextInt();
		 
			new BillDao().billing(meter);
			System.out.println();
			System.out.println("***************************");
			System.out.println(" enter unit");
			int unit = sc.nextInt();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println( "DATE and TIME of generated bill is:"  +dtf.format(now));
			System.out.println();
			System.out.println("***************************");
			if (unit <= 100) {
				billToPay = unit * 4.40;
			}

			else if (unit <= 300) {
				billToPay = 100 * 4.40 + (unit - 100) * 2;
			}

			else if (unit > 300) {
				billToPay = 100 * 4.40 + 200 * 2 + (unit - 300) * 3;
			}
			
			System.out.println("you have to pay for" + unit + " is : " + billToPay + "rs");
			 amount = billToPay;
		    new BillDao().billinsert(month, meter, unit, unit);
		    new Coustmercont().cust();
			
		}
	}
	}	
	}

