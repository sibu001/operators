package com.spring.jwt.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jwt.models.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long> {
	@Query(value ="select* from app_user where username=?", nativeQuery =true)
	AppUser findByUsername(String username);

}
