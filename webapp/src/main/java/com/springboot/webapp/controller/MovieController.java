package com.springboot.webapp.controller;


import com.springboot.webapp.entity.Movie;
import com.springboot.webapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/list")
public class MovieController {
    @Autowired
    private MovieService moviesService;

    @GetMapping("/movies")
    public List<Movie> findAll() {
        return moviesService.findAll();
    }


    @GetMapping("/movieofid/{movieId}")
    public Movie getMovie(@PathVariable int movieId) {
        Movie theMovie= moviesService.findById(movieId);
        return theMovie;
    }

}
