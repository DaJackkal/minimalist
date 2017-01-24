package org.minimalist.rest.spring.dao;

import org.minimalist.rest.spring.model.Movie;

import java.util.List;

public interface MovieDAO {

    List<Movie> getMovies();
    Movie getMovie(int id);

}
