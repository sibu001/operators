package com.springjpa.ebms.jwtFilter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomeAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Autowired
	AuthenticationManager authenticationManager;
	
	public CustomeAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager=authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String username = request.getParameter("emailId");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				username, password);

		return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User principal = (User) authResult.getPrincipal();
		Algorithm algorithm = Algorithm.HMAC256("pradeep".getBytes());
		String access_token = JWT.create().withSubject(principal.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + 10000000))
				.withIssuer(request.getRequestURI().toString()).withClaim("role", principal.getAuthorities().stream()
						.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(algorithm);
		
		
		String refresh_token= JWT.create().withSubject(principal.getUsername()).withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
		.withIssuer(request.getRequestURI().toString()).sign(algorithm);
		
		
		Map<String, String> tokens = new HashMap<>();
		tokens.put("access_token", access_token);
		tokens.put("refresh_token", refresh_token);
		response.setContentType("APPLICATION_JSON_VALUE");
		new ObjectMapper().writeValue(response.getOutputStream(), tokens);

		
	}

}
