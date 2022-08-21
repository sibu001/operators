package com.springjpa.ebms.jwtFilter;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springjpa.ebms.entity.Customer;
import com.springjpa.ebms.repository.CustomerRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer findByEmail = this.customerRepo.FindByEmail(email);
		if (findByEmail == null) {
			throw new UsernameNotFoundException(email);
		} else {
			log.info(email);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		findByEmail.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});

		return new org.springframework.security.core.userdetails.User(findByEmail.getEmailId(), findByEmail.getPassword(),
				authorities);
	}

}
