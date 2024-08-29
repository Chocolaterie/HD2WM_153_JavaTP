package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.bo.Movie;
import eni.tp.app.eni_app.dao.IDAOMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieManager {

    @Autowired
    IDAOMovie daoMovie;

    public List<Movie> getAll() {
        // Récupérer les films via la DAO
        List<Movie> movies = daoMovie.selectMovies();

        return movies;
    }

    public Movie getById(long id) {
        // Récupérer le film via la DAO
        Movie movie = daoMovie.selectMovieById(id);

        return movie;
    }

    public void save(Movie movie){
        daoMovie.save(movie);
    }
}
