package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bll.MovieManager;
import eni.tp.app.eni_app.bo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    MovieManager movieManager;

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("movies")
    public String movies(Model model) {
        // Récuperer la liste
       List<Movie> movies = movieManager.getAll();

        // Envoyer les films dans le modele
        model.addAttribute("movies", movies);

        return "movies";
    }

    @GetMapping("movie-detail")
    public String movieDetail() {
        return "movie-detail";
    }
}
