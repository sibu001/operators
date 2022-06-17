package com.electricbilling.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.electricbilling.utility.Connect;

public class BillDao {
	public void billing(int meter) throws SQLException {
		Connection conn = Connect.connect1();
		Statement stm = conn.createStatement();
		String query = "select*from coustmer where meter_no = " + meter;
		stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
		System.out.printf("name \t" + "meter_no\t" + "address\t" + "state\t" + "city\t" + "phone_no\t");
		while (rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			String state = rs.getString("state");
			String city = rs.getString("city");
			String phone_no= rs.getString("phone_no");
			
            System.out.println();
			System.out.printf(name + "\t" + meter + "\t" + address + "\t" + state + "\t" + city + "\t" + phone_no +"\t");
		}
	}

	public void billinsert(String month, int meter, int unit, int amount) throws SQLException {
		Connection conn = Connect.connect1();
		Statement stm = conn.createStatement();
		String q4 = "insert into bill values('" + month + "'," + meter + "," + unit + "," + amount + ")";
		stm.executeUpdate(q4);
	}
}
