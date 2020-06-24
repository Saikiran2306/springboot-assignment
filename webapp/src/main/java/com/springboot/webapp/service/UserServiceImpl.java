package com.springboot.webapp.service;

import com.springboot.webapp.dao.UserRepository;
import com.springboot.webapp.entity.Role;
import com.springboot.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        System.out.println(id+"-----------------------------------------------------------");
        Optional<User> result = userRepository.findById(Integer.parseInt(id));
       // User user = null;
        if (result.isPresent() == false) {
            throw new UsernameNotFoundException("Invalid username / password.");
        }
        user = result.get();
        return new org.springframework.security.core.userdetails.User((""+user.getId()), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> result = userRepository.findById(theId);
        User theUser = null;
        if (result.isPresent()) {
            theUser = result.get();
        } else {
            throw new RuntimeException("Did not find user with id : " + theId);
        }
        return theUser;
    }

    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public boolean deleteById(int theId) {
        userRepository.deleteById(theId);
        return true;
    }

    @Override
    public User getLoggedUser() {
        return user;
    }
}
