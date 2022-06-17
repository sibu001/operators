package com.electricbilling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.electricbilling.utility.Connect;

public class UpdateDao {
	public void Udao(String name,int meter_no,String address,String state,String city,String phone) throws SQLException {
		String q = "update coustmer set name = ? , address = ? , state = ? , city = ? ,phone_no=? where meter_no =?";
		try (Connection conn = Connect.connect1(); PreparedStatement ps = conn.prepareStatement(q) ){
		ps.setString(1, name);
		ps.setInt(2, meter_no);
		ps.setString(3, address);
		ps.setString(4, state);
		ps.setString(5, city);	
		ps.setString(6, phone);
   
		ps.executeUpdate();
	   conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
}