package com.spring.jwt.Service;

import java.util.List;

import com.spring.jwt.models.AppUser;
import com.spring.jwt.models.Role;

public interface UserService {

	AppUser saveUser(AppUser user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String RoleName);

	AppUser addUser(String username);

	List<AppUser> getUser();

}
