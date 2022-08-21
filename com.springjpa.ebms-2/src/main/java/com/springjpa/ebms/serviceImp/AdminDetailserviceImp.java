//package com.springjpa.ebms.serviceImp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.springjpa.ebms.entity.AdminDetailService;
//import com.springjpa.ebms.entity.JwtRequest;
//import com.springjpa.ebms.repository.JwtRequestRepo;
//@Service
//public class AdminDetailserviceImp implements UserDetailsService {
//	@Autowired
//	public JwtRequestRepo jwtRequestRepo;
//
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		 JwtRequest findByUsername = this.jwtRequestRepo.FindByUsername(username);
//		if(findByUsername==null) {
//			throw new UsernameNotFoundException("kuch b mt daal bhai ...aisa kuch ni hai databse me chote");
//		}
//		return new AdminDetailService(findByUsername);
//		
//	}
//	
//}
