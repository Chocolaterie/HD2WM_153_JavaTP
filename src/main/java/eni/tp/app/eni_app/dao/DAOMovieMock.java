package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DAOMovieMock implements IDAOMovie {

    List<Movie> movies = Arrays.asList(
            new Movie(1L, "Velocipastor", 2017, 65, "Todo qdssssssss ds qdsq qs sqdddddddd sqdsqdqsd sqdddddd qdsdqs sqdqsdqs"),
            new Movie(2L, "Bulk", 2015, 65, "Todo"),
            new Movie(3L, "Bulk", 2015, 65, "Todo")
    );

    @Override
    public List<Movie> selectMovies() {
        return movies;
    }

    @Override
    public Movie selectMovieById(long id) {
        Movie movieToFound = movies.stream().filter(movie -> movie.id == id).findFirst().get();

        return movieToFound;
    }
}