package com.spring.jwt.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.jwt.Repo.RoleRepo;
import com.spring.jwt.Repo.UserRepo;
import com.spring.jwt.models.AppUser;
import com.spring.jwt.models.Role;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service

@Transactional
@Slf4j
@Data
public class UserServiceImp implements UserService, UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AppUser saveUser(AppUser user) {
		log.info("saving new user{} to the database", user.getName());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("saving new role{} to the database", role.getName());

		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String RoleName) {
		log.info("adding role {} to role {}", RoleName, username);
		AppUser findByUsername = this.userRepo.findByUsername(username);
		Role role = this.roleRepo.FindByName(RoleName);
		
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		findByUsername.setRoles(roles);
		this.userRepo.save(findByUsername);
	//	findByUsername.getRoles().add(role);
		
		
//		Collection<Role> roles = findByUsername.getRoles();
//		roles.add(role);
//		findByUsername.setRoles(roles);
//		this.userRepo.save(findByUsername);

	}

	@Override
	public AppUser addUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepo.findByUsername(username);
	}

	@Override
	public List<AppUser> getUser() {
		
		return this.userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = this.userRepo.findByUsername(username);
		if (user == null) {
			log.error("User not found in database");
			throw new UsernameNotFoundException(username);
		} else {
			log.info(username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}

}
