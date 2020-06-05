package com.springboot.webapp.service;


import com.springboot.webapp.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    boolean deleteById(int theId);
}
