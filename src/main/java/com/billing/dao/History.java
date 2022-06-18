package com.billing.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.billing.entity.Cdata;
import com.billing.utility.Connect;

public class History {
	public List<Cdata> record() {
		Connection conn = Connect.connect1();
		{
			try {
				Statement st = conn.createStatement();

				ResultSet rs = st.executeQuery("select * from coustmer");
				//System.out.printf("name \t" + "meter_no\t" + "address\t" + "state\t" + "city\t" + "phone_no\t");
               List<Cdata> al= new ArrayList<Cdata>();
				while (rs.next()) {
					Cdata c= new Cdata();
                   
					String name = rs.getString("name");
					int meter = rs.getInt("meter_no");
					String address = rs.getString("address");
					String state = rs.getString("state");
					String city = rs.getString("city");
					String phone_no= rs.getString("phone_no");
					
                  c.setAddress(address);
                  c.setCity(city);
                  c.setMeter_no(meter);
                  c.setName(name);
                  c.setPhone_no(phone_no);
                  c.setState(state);
                  al.add(c);
                  
				}
            return al;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	}

