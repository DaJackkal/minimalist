package org.minimalist.rest.spring.controller;

import org.apache.log4j.Logger;
import org.minimalist.rest.spring.dao.MovieDAO;
import org.minimalist.rest.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private static final Logger logger = Logger.getLogger(MoviesController.class);

    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Movie> getMovies(){
        logger.debug("PLMPLMPLM");
        return movieDAO.getMovies();
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public Movie getMovie(@PathVariable final int id){
        return movieDAO.getMovie(id);
    }

}