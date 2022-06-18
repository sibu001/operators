package com.billing.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.billing.entity.Billdata;
import com.billing.entity.Cdata;
import com.billing.utility.Connect;

public class BillDao {
	public Cdata billing(int meter) throws SQLException {
		try(Connection conn = Connect.connect1();){
		Statement stm = conn.createStatement();
		String query = "select*from coustmer where meter_no = " + meter;
		stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
		//System.out.printf("name \t" + "meter_no\t" + "address\t" + "state\t" + "city\t" + "phone_no\t");
		Cdata c= new Cdata();
		while (rs.next()) {
			
			String name = rs.getString("name");
			int meter_no= rs.getInt("meter_no");
			String address = rs.getString("address");
			String state = rs.getString("state");
			String city = rs.getString("city");
			String phone_no= rs.getString("phone_no");
			c.setName(name);
			c.setMeter_no(meter_no);
			c.setAddress(address);
			c.setCity(city);
			c.setState(state);
			c.setPhone_no(phone_no);
			}
		return c;
	}catch(SQLException e) {
		e.printStackTrace();
		return null;
	}
	}
	public void billinsert(Billdata bd) throws SQLException {
		Connection conn = Connect.connect1();
		Statement stm = conn.createStatement();
		String q4 = "insert into bill values('" + bd.getMonth() + "'," + bd.getMeter_no() + "," + bd.getUnit() + "," + bd.getAmount() + ")";
		stm.executeUpdate(q4);
	}
}
