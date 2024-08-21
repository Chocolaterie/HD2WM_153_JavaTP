package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DAOMovieMock implements IDAOMovie {

    @Override
    public List<Movie> selectMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1L, "Velocipastor", 2017, 65, "Todo"));
        movies.add(new Movie(2L, "Bulk", 2015, 65, "Todo"));
        movies.add(new Movie(2L, "Bulk", 2015, 65, "Todo"));

        return movies;
    }
}
