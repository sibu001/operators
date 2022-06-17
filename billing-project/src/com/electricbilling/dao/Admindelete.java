package com.electricbilling.dao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.electricbilling.utility.Connect;



public class Admindelete {
	Connection conn;
	public void delete(int meter_no) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		
			String sql = "delete from coustmer where meter_no = ?";
			try {
				Connection conn = Connect.connect1();PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, meter_no);
				ps.executeUpdate();
				System.out.println("recorde deleted");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	 }
	


