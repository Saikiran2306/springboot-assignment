package com.springboot.webapp.service;


import com.springboot.webapp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService  {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    boolean deleteById(int theId);

    User getLoggedUser();

}
