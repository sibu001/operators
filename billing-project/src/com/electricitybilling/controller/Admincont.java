package com.electricitybilling.controller;

import java.util.Scanner;
import com.electricbilling.view.Admin;
import com.electricbilling.view.*;
public class Admincont {
	
	public void admin() {
		try(Scanner in = new Scanner(System.in);)
				{
					new Admin().adminlogin();
					int n = in.nextInt();
					switch(n){
		case 1:
			new Adminprofile().profile();
			break;
		case 2:
			new Adminprofile().update();
		     break;
		case 3: 
			new Adminprofile().delete();
			break;
		case 4: 
			new Adminprofile().history();
			break;
		case 5: 
			new Logincont().login();
			break;
		case 6: 
			System.exit(0);
			break;
		default:
			System.out.println("Choose a valid Number");
			this.admin();
		}
	}catch(Exception e) {
		System.out.println("Characters not allowed");
		e.printStackTrace();
	}

		}
	}
