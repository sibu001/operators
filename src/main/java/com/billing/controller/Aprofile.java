package com.billing.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.billing.entity.Cdata;
import com.billing.service.Insertservice;

//
@WebServlet("/hit")
public class Aprofile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str= req.getParameter("hit");
		if(str.equals("update")) {
			try {
				this.update(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(str.equals("delete")) {
			try {
				this.delete(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(str.equals("view customer's history")) {
			try {
				this.history(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
		public void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
			int meter = Integer.parseInt(req.getParameter("user_meterno"));
			String name = req.getParameter("user_name");
			String address = req.getParameter("address");
			String state = req.getParameter("user_state");
			String city = req.getParameter("user_city");
			String phone = req.getParameter("phone");
			Cdata c = new Cdata();
			c.setAddress(address);
			c.setCity(city);
			c.setMeter_no(meter);
			c.setName(name);
			c.setPhone_no(phone);
			c.setState(state);
			new Insertservice().update(c);
			req.getRequestDispatcher("Admin.jsp").include(req, resp);
		}
		
		private void history(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
			List<Cdata> al = Insertservice.view();
			req.setAttribute("see", al);
			req.getRequestDispatcher("View.jsp").include(req, resp);
		}
		
		public void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
			int meter_no = Integer.parseInt(req.getParameter("user_meterno"));
			Cdata c = new Cdata();
			c.setMeter_no(meter_no);
			new Insertservice().erase(c);
			req.getRequestDispatcher("Admin.jsp").include(req, resp);
		}

	}


