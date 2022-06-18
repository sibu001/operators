package com.billing.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.util.PSQLException;

import com.billing.entity.*;
import com.billing.utility.Connect;

public class AdminproDao {

	public int prodao(Cdata c) throws SQLException, IOException, Exception, Exception {
		Connection conn = Connect.connect1();
		try {
			Statement stm = conn.createStatement();
			String q2 = "insert into coustmer values('" + c.getName() + "'," + c.getMeter_no() + ",'" + c.getAddress()
					+ "','" + c.getState() + "','" + c.getCity() + "'," + c.getPhone_no() + ")";
			System.out.println(q2);
			int n = stm.executeUpdate(q2);
			return n;
		} catch (PSQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

}