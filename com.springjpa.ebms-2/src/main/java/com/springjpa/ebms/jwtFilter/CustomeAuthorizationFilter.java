package com.springjpa.ebms.jwtFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomeAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/api/login")) {
			filterChain.doFilter(request, response);
		} else {
			String header = request.getHeader("Authorization");
			if (header != null && header.startsWith("Bearer ")) {
				try {
					String token = header.substring("Bearer ".length());
					Algorithm algorithm = Algorithm.HMAC256("pradeep".getBytes());
					JWTVerifier jwtVerifier = JWT.require(algorithm).build();
					DecodedJWT verify = jwtVerifier.verify(token);
					String username = verify.getSubject();
					String[] roles = verify.getClaim("role").asArray(String.class);
					Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
					Arrays.stream(roles).forEach(role -> {
						authority.add(new SimpleGrantedAuthority(role));
					});
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							username, null, authority);
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					filterChain.doFilter(request, response);

				} catch (Exception e) {
					log.error("Error loggin in {}", e.getMessage());
					response.setHeader("error", e.getMessage());
				}

			} else {
				filterChain.doFilter(request, response);

			}
		}

	}

}
