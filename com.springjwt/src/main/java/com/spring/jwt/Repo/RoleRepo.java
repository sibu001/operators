package com.spring.jwt.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jwt.models.Role;

public interface RoleRepo  extends JpaRepository<Role, Long>{
	@Query(value ="select* from role where name=?",nativeQuery = true)
	Role FindByName(String name);

}
