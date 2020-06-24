package com.springboot.webapp.dao;

import com.springboot.webapp.entity.Role;
import com.springboot.webapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
