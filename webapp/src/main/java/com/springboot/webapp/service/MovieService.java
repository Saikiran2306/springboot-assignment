package com.springboot.webapp.service;

import com.springboot.webapp.entity.Movie;

import java.util.List;

public interface MovieService {


     List<Movie> findAll();

     Movie findById(int theId);

     Movie save(Movie theMovie);

     boolean deleteById(int theId);

    List<Movie> findByMovieName(String uId);

    List<Movie> findByLanguage(String uId);

    List<Movie> findByGenre(String uId);

    List<Movie> findByYear(String uId);
}
