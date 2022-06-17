package com.electricbilling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.electricbilling.utility.Connect;

public class AdminDao {


	public String dao(String usr) {
		String query ="select* from LOGIN where username = ?";
		try (Connection conn = Connect.connect1(); PreparedStatement pst = conn.prepareStatement(query) ) {
			pst.setString(1, usr);
			ResultSet rs = pst.executeQuery();
		String pws = null;
			while (rs.next()) {
			pws = rs.getString(2);
			}
			return pws;
		}catch (Exception e) {
			
		}
		return null;

	}
}