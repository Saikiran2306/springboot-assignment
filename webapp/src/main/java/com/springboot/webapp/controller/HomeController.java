package com.springboot.webapp.controller;

import com.springboot.webapp.service.MovieService;
import com.springboot.webapp.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserMovieService userMovieService;

    @Autowired
    private MovieService movieService;

    @RequestMapping("/home")
    public String home(Model theModel) {
        theModel.addAttribute("usermovies", userMovieService.findAll());

        return "home";
    }

    @RequestMapping("/home/listmovies")
    public String list(@RequestParam("keyword") String keyword, @RequestParam("findby") String findBy, Model theModel1, Model theModel2) {
        if (findBy.equals("actor")) {
            userMovieService.findByActor(keyword);
            theModel1.addAttribute("usermovies", userMovieService.findByActor(keyword));
            return "home";
        } else if (findBy.equals("all") || keyword.trim().length() == 0) {

            theModel1.addAttribute("usermovies", userMovieService.findAll());
            return "home";
        } else {

            switch (findBy) {
                case "movie":
                    theModel2.addAttribute("movies", movieService.findByMovieName(keyword));
                    break;
                case "language":
                    theModel2.addAttribute("movies", movieService.findByLanguage(keyword));
                    break;
                case "genre":
                    theModel2.addAttribute("movies", movieService.findByGenre(keyword));
                    break;
                case "year":
                    theModel2.addAttribute("movies", movieService.findByYear(keyword));
                    break;

                default:
                    break;
            }
            return "movies";
        }
    }
}
