package com.springboot.webapp.dao;

import com.springboot.webapp.entity.Movie;
import com.springboot.webapp.entity.User;
import com.springboot.webapp.entity.UserMovie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


public interface UserMovieRepository extends JpaRepository<UserMovie, Integer> {

    List<UserMovie> findByUser(User user);

    List<UserMovie> findByMovie(Movie movie);

    default List<UserMovie> findByActor(String uId) {
        List<UserMovie> tempUserMovie = new ArrayList<>();
        for (UserMovie um : findAll()) {
            if (um.getUser().getFirstName().toLowerCase().equals(uId.toLowerCase()) ||
                    um.getUser().getLastName().toLowerCase().equals(uId.toLowerCase())) {
                tempUserMovie.add(um);
            }
        }
        return tempUserMovie;
    }
}
