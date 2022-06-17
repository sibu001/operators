package com.electricbilling.dao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.electricbilling.utility.Connect;
import com.electricitybilling.entity.*;
public class AdminproDao {
	
	public void prodao(CEntity en) throws SQLException, IOException, Exception, Exception {
		Connection conn = Connect.connect1();
		Statement stm = conn.createStatement();
		String q2 = "insert into coustmer values('" + en.getName() + "'," + en.getMeter_no() + ",'" + en.getAddress() + "','" + en.getState()
				+ "','" + en.getCity() + "'," + en.getPhone_no() + ")";
		System.out.println(q2);
		stm.executeUpdate(q2);
	}

	

}
