package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Movie;

import java.util.List;

public interface IDAOMovie {

    List<Movie> selectMovies();

    Movie selectMovieById(long id);

    void save(Movie movie);

}
