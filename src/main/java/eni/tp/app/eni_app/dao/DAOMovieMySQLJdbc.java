package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Profile("mysql")
@Component
public class DAOMovieMySQLJdbc implements IDAOMovie {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static final RowMapper<Movie> MOVIE_ROW_MAPPER = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();

            movie.setId(rs.getLong("id"));
            movie.setTitle(rs.getString("title"));
            movie.setNote(rs.getInt("note"));
            movie.setYear(rs.getInt("year"));
            movie.setDuration(rs.getInt("duration"));
            movie.setSynopsis(rs.getString("synopsis"));

            return movie;
        }
    };

    @Override
    public List<Movie> selectMovies() {
        return jdbcTemplate.query("SELECT * FROM movie", MOVIE_ROW_MAPPER);
    }

    @Override
    public Movie selectMovieById(long id) {

        List<Movie> movies = jdbcTemplate.query("SELECT * FROM movie WHERE id = ?", MOVIE_ROW_MAPPER, id);

        if (movies.size() == 0) {
            return null;
        }

        return movies.get(0);
    }

    @Override
    public void save(Movie movie) {
        // Si le film existe deja alors c'est un update
        if (movie.getId() != null && selectMovieById(movie.getId()) != null) {
            // Requête update
            jdbcTemplate.update("UPDATE movie SET title = ?, year = ?, duration = ?, synopsis = ? WHERE id = ?",
                    movie.title, movie.year, movie.duration, movie.synopsis, movie.id);

            // PS : Return dans un void retourne pas de valeur mais stop le code de la function
            return;
        }
        // Sinon insert
        jdbcTemplate.update("INSERT INTO movie (title, note, year, duration, synopsis) VALUES (?, ?, ?, ?, ?)",
                movie.title, 3, movie.year, movie.duration, movie.synopsis);
    }
}
