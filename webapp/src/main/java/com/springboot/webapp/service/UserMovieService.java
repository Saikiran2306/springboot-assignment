package com.springboot.webapp.service;

import com.springboot.webapp.entity.Movie;
import com.springboot.webapp.entity.User;
import com.springboot.webapp.entity.UserMovie;

import java.util.List;

public interface UserMovieService {

    List<UserMovie> findAll();

    UserMovie findById(int theId);

    UserMovie save(UserMovie theUserMovie);

    boolean deleteById(int theId);

    List<UserMovie> findByUser(User user);

    List<UserMovie> findByMovie(Movie movie);

    List<UserMovie> findByActor(String uId);
}
