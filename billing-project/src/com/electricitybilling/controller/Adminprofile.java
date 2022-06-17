package com.electricitybilling.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import com.electricbilling.dao.*;
import com.electricbilling.service.Limitation;
import com.electricitybilling.entity.CEntity;

public class Adminprofile {
	void profile() throws SQLException {
		try (Scanner in = new Scanner(System.in);) {

			while (true) {
				System.out.println("enter customer name");
				in.nextLine();
				String name = in.nextLine();
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
					
					e.printStackTrace();
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				System.out.println("do you want one more record(yes/no)");
				String option = in.next();
				if (option.equals("no")) {
					new Admincont().admin();
				}
			}
		}
	}

	public void update() throws SQLException {
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
				new Admincont().admin();
			}
		}
	}

	public void delete() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("enter meter number ");
			int meter = in.nextInt();
			try {
				new Admindelete().delete(meter);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new Admincont().admin();
		}
	}

	public void history() {
		new History().record();
		System.out.println();
		System.out.println("**************************");
		new Admincont().admin();
	}
}