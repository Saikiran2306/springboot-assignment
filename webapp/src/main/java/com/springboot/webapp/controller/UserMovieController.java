package com.springboot.webapp.controller;

import com.springboot.webapp.entity.Movie;
import com.springboot.webapp.entity.User;
import com.springboot.webapp.entity.UserMovie;
import com.springboot.webapp.service.MovieService;
import com.springboot.webapp.service.UserMovieService;
import com.springboot.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserMovieController {

    @Autowired
    private UserMovieService userMovieService;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/usersmovies")
    public List<UserMovie> getUserMovies() {
        return userMovieService.findAll();
    }

    @GetMapping("/usermovieofid/{umId}")
    public UserMovie getuserMovie(@PathVariable int umId) {
        UserMovie theUserMovie = userMovieService.findById(umId);
        return theUserMovie;
    }

    @GetMapping("/moviesbyid")
    public String getAllMoviesById(@RequestParam("uid") String userId, Model theModel) {

        try {
            User theUser = userService.findById(Integer.parseInt(userId));

            theModel.addAttribute("usermovies", userMovieService.findByUser(theUser));

            return "list-allmovies-actor";
        } catch (Exception e) {
            theModel.addAttribute("invalidId", userId);
            return "invalid-actor";
        }
    }

    @GetMapping("/usersbyid/{mId}")
    public List<UserMovie> getAllUsersById(@PathVariable int mId) {

        Movie theMovie = movieService.findById(mId);

        return userMovieService.findByMovie(theMovie);
    }


}
