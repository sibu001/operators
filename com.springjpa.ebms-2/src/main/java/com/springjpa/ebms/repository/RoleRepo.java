package com.springjpa.ebms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springjpa.ebms.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	@Query(value="select*from role where role_name=?",nativeQuery = true)
	Role FindByName(String name);

}
