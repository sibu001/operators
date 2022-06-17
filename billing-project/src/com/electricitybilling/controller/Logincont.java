package com.electricitybilling.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.electricbilling.service.Adminservice;
import com.electricbilling.view.*;

public class Logincont {
	public void login() {
		try (Scanner in = new Scanner(System.in);) {
			new Login().loginmenu();

			int n = in.nextInt();
			switch (n) {
			case 1:
				this.coustomerlog();
				break;
			case 2:
				this.adminlogin();
				break;

			default:
				System.out.println("Please choose a correct number");
				login();
				break;
			}
		} catch (Exception e) {
			System.out.println("Characters not allowed");
			this.login();
		}
	}

	public void adminlogin() throws SQLException {

		try (Scanner in = new Scanner(System.in);) {
			System.out.println("enter your user name");
			String usr = in.next();
			System.out.println("enter password");
			String pws = in.next();
			if (Adminservice.loginservice(usr, pws)) {
				new Admincont().admin();
			} else {
				System.out.println("Invalid username or password");
				this.login();
			}

		}
	}

	void coustomerlog() throws SQLException {
		new Coustmercont().cust();

	}
}