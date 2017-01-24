package org.minimalist.rest.spring.dao;

import org.minimalist.rest.spring.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcMovieDAO implements MovieDAO {

    private final static String TABLE_MOVIE = "movies";
    private final static String COLUMN_ID = "id";
    private final static String COLUMN_NAME = "name";
    private final static String COLUMN_YEAR = "year";

    private final static String SELECT_FROM = "SELECT " + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_YEAR + " FROM " + TABLE_MOVIE;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMovieDAO(final DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        return this.jdbcTemplate.query(SELECT_FROM, new MovieRowMapper());
    }

    @Override
    public Movie getMovie(int id) {
        return this.jdbcTemplate.queryForObject(SELECT_FROM + " WHERE id = ?", new MovieRowMapper(), id);
    }

    private static final class MovieRowMapper implements RowMapper<Movie>{

        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            final int id = rs.getInt(COLUMN_ID);
            final String name = rs.getString(COLUMN_NAME);
            final int year = rs.getInt(COLUMN_YEAR);
            return new Movie(id, name, year);
        }
    }
}
