package com.springboot.webapp.service;

import com.springboot.webapp.dao.RoleRepository;
import com.springboot.webapp.dao.UserMovieRepository;
import com.springboot.webapp.entity.Role;
import com.springboot.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int theId) {
        Optional<Role> result = roleRepository.findById(theId);
        Role theRole = null;
        if (result.isPresent()) {
            theRole = result.get();
        } else {
            throw new RuntimeException("Did not find role with id : " + theId);
        }
        return theRole;
    }
}
