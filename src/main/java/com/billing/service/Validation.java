package com.billing.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;


//
@WebFilter("/operation")
public class Validation implements Filter {
	
	Logger logger = (Logger) LoggerFactory.getLogger(Validation.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String str= request.getParameter("operation");
		if(str.equals("insert")) {
			this.profiledata(request, response, chain);
		}
		if(str.equals("pay")) {
			this.invoice(request, response, chain);
		}
	}
		
		public void profiledata(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String phone_no= request.getParameter("phone");
		int meter_no= Integer.parseInt(request.getParameter("user_meterno"));
		if(Limitation.pattern(phone_no) && Limitation.meter(meter_no)) {
			chain.doFilter(request, response);
			 ((org.slf4j.Logger) logger).debug("request path:{}",((HttpServletRequest)request).getContextPath());
		}
		else {
			request.getRequestDispatcher("customer.jsp").include(request, response);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h3> please..Ensure input formate is valid....TRY AGAIN </h3>");
			((org.slf4j.Logger) logger).error("logger calling");
		}	
	}
		
		public void invoice(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
			int meter_no= Integer.parseInt(request.getParameter("user_meterno"));
			if( Limitation.meter(meter_no)) {
				chain.doFilter(request, response);
			}
			else {
				request.getRequestDispatcher("customer.jsp").include(request, response);
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<h3> sorry!!!meter number is not valid..TRY AGAIN </h3>");
			}
			
			
		}
		
		
		
		
		
		
	@Override
	public void destroy() {
		((org.slf4j.Logger) logger).error("logger is destroyed");
		
	}
	

}
