package com.spring.jwt.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.jwt.Service.UserService;
import com.spring.jwt.models.AppUser;
import com.spring.jwt.models.Role;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
	@Autowired
	private  UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getUser(){
		return ResponseEntity.ok().body(userService.getUser());
		
	}
	
	
	@PostMapping("/users/save")
	public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser){
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(appUser));
		
	}
	
	@PostMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role ){
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
		
	}
	
	@PostMapping("/role/addRoleToUser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser roleToUser ){
		System.out.println(roleToUser);
		userService.addRoleToUser(roleToUser.getUsername(), roleToUser.getRole());
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	

}

@Data
class RoleToUser{
	private String username;
	private String role;
}








