package com.electricbilling.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;

import com.electricbilling.utility.Connect;

public class History {
	public void record() {
		Connection conn = Connect.connect1();
		{
			try {
				Statement st = conn.createStatement();

				ResultSet rs = st.executeQuery("select * from coustmer");
				System.out.printf("name \t" + "meter_no\t" + "address\t" + "state\t" + "city\t" + "phone_no\t");

				while (rs.next()) {

					String name = rs.getString("name");
					int meter = rs.getInt("meter_no");
					String address = rs.getString("address");
					String state = rs.getString("state");
					String city = rs.getString("city");
					String phone_no= rs.getString("phone_no");
					
                    System.out.println();
					System.out.printf(name + "\t" + meter + "\t" + address + "\t" + state + "\t\t" + city + "\t" + phone_no +"\t");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	}

