package com.electricitybilling.controller;

import com.electricbilling.view.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Coustmercont {
	public void cust() throws SQLException {
		try (Scanner in = new Scanner(System.in);) {
			new Coustmer().coustmerlogin();
			int n = in.nextInt();
			switch (n) {
			case 1:
				new Coustmerprofile().profile();
				break;
			case 2:
				new Coustmerprofile().Cupdate();
				break;
			case 3:
				new Coustmerprofile().bill();
				break;
			case 4: 
				new Logincont().login();
				break;
			case 5:
				System.exit(0);
				break;
				
			default:
				System.out.println("Choose a valid Number");
				this.cust();
			}
		}catch(Exception e) {
			e.printStackTrace();
		
		}

			}
				

			
		}
	
