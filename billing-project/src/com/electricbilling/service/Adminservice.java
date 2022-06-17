package com.electricbilling.service;

import com.electricbilling.dao.*;

public class Adminservice{
	
	public static boolean loginservice(String usr, String pws) {

		try {
			String pas = new AdminDao().dao(usr);
			if (pas.equals(pws)) {
				return true;
			} else {
				System.out.println("username or password is incorrect");
				System.out.println("try again");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
