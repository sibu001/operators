package com.billing.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import com.billing.entity.*;
import com.billing.service.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.billing.entity.*;

//
@WebServlet("/operation")
public class Cprofile extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str = req.getParameter("operation");
		if (str.equals("insert")) {
			try {
				this.insertdata(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}
		} 
		 else if (str.equals("pay")) {
			try {
				this.paybill(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		} 
	

	// insert data into database
	private void insertdata(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String name = req.getParameter("user_name");
		int meter_no = Integer.parseInt(req.getParameter("user_meter"));
		String address = req.getParameter("address");
		String state = req.getParameter("user_state");
		String city = req.getParameter("user_city");
		String phone = req.getParameter("phone");
		Cdata c = new Cdata();
		c.setName(name);
		c.setAddress(address);
		c.setCity(city);
		c.setMeter_no(meter_no);
		c.setState(state);
		c.setPhone_no(phone);
		if (Insertservice.insertdata(c)) {
			out.print("Successfully inserted");
			req.getRequestDispatcher("customer.jsp").include(req, resp);
		}else {
			out.print("<html><body><h2><b>Arey baap ree...Something went wrong or meter number is already existed<b><h2><body><html>");
		}

	}

	

	private void paybill(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		String month = req.getParameter("user_month");
		int meter_no = Integer.parseInt(req.getParameter("user_meterno"));
		int unit = Integer.parseInt(req.getParameter("unit"));
		Billdata bd = new Billdata();
		bd.setUnit(unit);
		bd.setMonth(month);
		bd.setMeter_no(meter_no);
		double amount = new Insertservice().getbillamount(unit);
		bd.setAmount(amount);
		Cdata c = Insertservice.billing(meter_no);
		if(c==null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<h3> meter number is not existed </h3>");
		}else {
		new Insertservice().gobillinsert(bd);
		req.setAttribute("billing", c);
		req.setAttribute("invoice", bd);
		req.getRequestDispatcher("calculation.jsp").include(req, resp);
	}

	

	}	
}
