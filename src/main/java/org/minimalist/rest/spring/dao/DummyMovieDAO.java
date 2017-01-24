package org.minimalist.rest.spring.dao;

import org.minimalist.rest.spring.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class DummyMovieDAO implements MovieDAO {

    private List<Movie> movies = new ArrayList(){{
        add(new Movie(1, "Movie 1", 1989));
        add(new Movie(2, "Movie 2", 1990));
        add(new Movie(3, "Movie 3", 1991));
    }};

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public Movie getMovie(final int id) {
        return movies.stream().filter(s -> s.getId() == id).findFirst().get();
    }
}
