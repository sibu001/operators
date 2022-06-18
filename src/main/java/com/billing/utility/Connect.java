package com.billing.utility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connect {
	public static Connection connect1() {
		Connection conn = null;
		try (FileInputStream file = new FileInputStream(
				"C:\\java\\workspace\\Billing_project_web\\src\\main\\java\\com\\billing\\utility/file.properties");) {
			Properties prop = new Properties();
			prop.load(file);
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("URL"), prop.getProperty("user"),
					prop.getProperty("password"));
			 System.out.println("Connected to the PostgreSQL server successfully.");
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
         
	}
	public static void main(String[] args) {
		System.out.println(connect1());
	}
	
}
