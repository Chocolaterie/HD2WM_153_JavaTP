package eni.tp.app.eni_app.bo;

public class Movie {

    public Long id;
    public String title;
    public int year;
    public int duration;
    public String synopsis;

    public Movie(Long id, String title, int year, int duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }
}
