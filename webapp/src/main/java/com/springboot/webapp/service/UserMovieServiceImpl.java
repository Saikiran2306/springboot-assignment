package com.springboot.webapp.service;

import com.springboot.webapp.dao.MovieRepository;
import com.springboot.webapp.dao.UserMovieRepository;
import com.springboot.webapp.entity.Movie;
import com.springboot.webapp.entity.User;
import com.springboot.webapp.entity.UserMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMovieServiceImpl implements UserMovieService {

    @Autowired
    private UserMovieRepository userMovieRepository;

    @Override
    public List<UserMovie> findAll() {
        return userMovieRepository.findAll();
    }

    @Override
    public UserMovie findById(int theId) {
        Optional<UserMovie> result = userMovieRepository.findById(theId);
        UserMovie theUserMovie = null;
        if (result.isPresent()) {
            theUserMovie = result.get();
        } else {
            throw new RuntimeException("Did not find movie_user with id : " + theId);
        }
        return theUserMovie;
    }

    @Override
    public UserMovie save(UserMovie theUserMovie) {
        return userMovieRepository.save(theUserMovie);
    }

    @Override
    public boolean deleteById(int theId) {

        userMovieRepository.deleteById(theId);
        return false;
    }

    @Override
    public List<UserMovie> findByUser(User user) {
        return userMovieRepository.findByUser(user);
    }

    @Override
    public List<UserMovie> findByMovie(Movie movie) {
        return userMovieRepository.findByMovie(movie);
    }

    @Override
    public List<UserMovie> findByActor(String uId) {
        return userMovieRepository.findByActor(uId);
    }


}
