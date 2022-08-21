package com.springjpa.ebms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.ebms.entity.Role;
import com.springjpa.ebms.service.CustomerService;

import lombok.Data;

@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/save/role")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		System.out.println(role);
		Role saveRole = this.customerService.saveRole(role);
		System.out.println(saveRole);
		return new ResponseEntity<Role>(saveRole, HttpStatus.CREATED);

	}

	@PostMapping("/save/addRoleToUser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser roleToUser) {

		this.customerService.addRoleToUser(roleToUser.getUsername(), roleToUser.getRole());

		return ResponseEntity.ok().build();

	}

}

@Data
class RoleToUser {
	private String username;
	private String role;

}
