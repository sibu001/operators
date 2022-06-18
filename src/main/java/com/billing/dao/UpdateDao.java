package com.billing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.billing.entity.Cdata;
import com.billing.utility.Connect;

public class UpdateDao {
	public void Udao(Cdata c) throws SQLException {
		String q = "update coustmer set name = ? , address = ? , state = ? , city = ? ,phone_no=? where meter_no =?";
		try (Connection conn = Connect.connect1(); PreparedStatement ps = conn.prepareStatement(q)) {
			ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
			ps.setString(3, c.getState());
			ps.setString(4, c.getCity());
			ps.setString(5, c.getPhone_no());
			ps.setInt(6, c.getMeter_no());

			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}