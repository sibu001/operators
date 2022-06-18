package com.billing.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
@SuppressWarnings("serial")
@WebFilter("/login")
public class Signin extends HttpFilter {

	@Override
	public void init() throws ServletException {

	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String username = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		if (username.equals("sibu")) {
			if (password.equals("1234")) {
				chain.doFilter(request, response);

			} else {
				request.getRequestDispatcher("loj.jsp").include(request, response);
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<h3> Username or Password is wrong....Try again </h3>");

			}
		}
//		} else {
//			request.getRequestDispatcher("loj.jsp").include(request, response);
//			PrintWriter out = response.getWriter();
//			response.setContentType("text/html");
//			out.println("<h3>username is wrong </h3>");
//
//		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
