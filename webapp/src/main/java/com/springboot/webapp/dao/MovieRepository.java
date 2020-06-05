package com.springboot.webapp.dao;

import com.springboot.webapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByMovieName(String uId);

    List<Movie> findByLanguage(String uId);

    List<Movie> findByGenre(String uId);

    List<Movie> findByYear(String uId);
}
