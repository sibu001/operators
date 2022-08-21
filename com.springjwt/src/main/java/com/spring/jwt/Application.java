package com.spring.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.jwt.Service.UserService;
import com.spring.jwt.Service.UserServiceImp;
import com.spring.jwt.models.AppUser;
import com.spring.jwt.models.Role;

@SpringBootApplication

public class Application   {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	public 
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
      
     
//     @Bean 
//	CommandLineRunner run(UserService userService)  {
//		return args->{
//		userService.saveRole(new Role(0,"Role_User"));
//		userService.saveRole(new Role(0,"Role_Admin"));
//		
//		
//		userService.saveUser(new AppUser(0,"pradeep","pshri","12345",new ArrayList<>()));
//		userService.saveUser(new AppUser(0,"sibu","abc","54321",new ArrayList<>()));
//		
//		
//		userService.addRoleToUser("pradeep","Role_User");
//		userService.addRoleToUser("sibu", "Role_Admin");
//		
//		
//	};


//	
//	}
    
//    @Autowired
//	private  UserService userService ;
//    @Override
//	public void run(String... args) throws Exception {
//    	 
//    	userService.saveRole(new Role(0,"Role_User"));
//		userService.saveRole(new Role(0,"Role_Admin"));
//		
//		
//		userService.saveUser(new AppUser(0,"pradeep","pshri","12345",new ArrayList<Role>()));
//		userService.saveUser(new AppUser(0,"sibu","abc","54321",new ArrayList<>()));
//		
//		
//		userService.addRoleToUser("pradeep","Role_User");
//		userService.addRoleToUser("sibu", "Role_Admin");
//		
//		
//	}	

}
