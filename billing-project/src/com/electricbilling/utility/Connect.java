package com.electricbilling.utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
	
	public static Connection connect1()  {
		Connection conn = null ;
		try(FileInputStream File = new FileInputStream("src/com/electricbilling/utility/File.properties");) {
			Properties prop = new Properties();
			prop.load(File);
			Class.forName(prop.getProperty("driver")); 
			conn = DriverManager.getConnection(prop.getProperty("URL"),prop.getProperty("user"),
					prop.getProperty("password"));
			//System.out.println("Connected to the PostgreSQL server successfully.");
		}  catch(Exception e) {
			e.printStackTrace();
		}
        
		return conn;
		
	}

//	public static void main(String[] args)  {
//		
//	 Connect.connect1();
//		
//	}
	
}		

