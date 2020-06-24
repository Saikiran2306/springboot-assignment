package com.springboot.webapp.service;

import com.springboot.webapp.entity.Role;
import com.springboot.webapp.entity.User;

import java.util.List;

public interface RoleService {


    List<Role> findAll();

    Role findById(int theId);
}
