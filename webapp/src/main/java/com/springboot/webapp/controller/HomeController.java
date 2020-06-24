package com.springboot.webapp.controller;

import com.springboot.webapp.entity.User;
import com.springboot.webapp.service.MovieService;
import com.springboot.webapp.service.UserMovieService;
import com.springboot.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserMovieService userMovieService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model theModel1,Model theModel2) {
        theModel1.addAttribute("usermovies", userMovieService.findAll());

        theModel2.addAttribute("user", userService.getLoggedUser());
        return "home";
    }

    @RequestMapping("/")
    public String defaultPage()
    {
        return "home";
    }

    @RequestMapping("/home/listmovies")
    public String list(@RequestParam("keyword") String keyword, @RequestParam("findby") String findBy, Model theModel1, Model theModel2,Model theModel3) {
        theModel3.addAttribute("user", userService.getLoggedUser());
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

    @GetMapping("/updateDetails")
    public String updateForm(@RequestParam("userId") int theId,Model theModel)
    {
        User theUser=userService.findById(theId);

        theModel.addAttribute("user",theUser);

        return "";
    }

}
