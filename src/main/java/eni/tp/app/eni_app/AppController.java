package eni.tp.app.eni_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("movies")
    public String movies() {
        return "movies";
    }

    @GetMapping("movie-detail")
    public String movieDetail() {
        return "movie-detail";
    }
}
