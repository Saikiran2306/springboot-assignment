package com.springboot.webapp.service;

import com.springboot.webapp.dao.MovieRepository;
import com.springboot.webapp.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int theId) {
        Optional<Movie> result = movieRepository.findById(theId);
        Movie theMovie = null;
        if (result.isPresent()) {
            theMovie = result.get();
        } else {
            throw new RuntimeException("Did not find movie with id : " + theId);
        }
        return theMovie;
    }

    @Override
    public Movie save(Movie theMovie) {
        return movieRepository.save(theMovie);

    }

    @Override
    public boolean deleteById(int theId) {

        movieRepository.deleteById(theId);
        return true;

    }

    @Override
    public List<Movie> findByMovieName(String uId) {
        return movieRepository.findByMovieName(uId);
    }

    @Override
    public List<Movie> findByLanguage(String uId) {
        return movieRepository.findByLanguage(uId);
    }

    @Override
    public List<Movie> findByGenre(String uId) {
        return movieRepository.findByGenre(uId);
    }

    @Override
    public List<Movie> findByYear(String uId) {
        return movieRepository.findByYear(uId);
    }

}
