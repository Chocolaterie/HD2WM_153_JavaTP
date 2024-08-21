package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Movie;

import java.util.List;

public interface IDAOMovie {

    List<Movie> selectMovies();
}
