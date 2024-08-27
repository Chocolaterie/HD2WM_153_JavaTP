package eni.tp.app.eni_app.bo;

import jakarta.validation.constraints.*;

public class Movie {

    public Long id;

    @NotBlank(message = "Le titre doit être renseigné")
    public String title;

    // Temporaire => Plus tard les notes = associations avis
    public int note = 2;

    @Min(value = 1895, message = "Veuillez saisir année cohérante")
    public int year;

    @Min(value = 1, message = "Il faut au moins 1 min")
    public int duration;

    @NotBlank(message = "Le synospsis est obligatoire")
    public String synopsis;

    public Movie() {}

    public Movie(Long id, String title, int year, int duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    /**
     * Récupère la note sur un format int
     * @return
     */
    public int getNote() {
        // Plus tard quand on va supprimer le int note
        // La note sera la moyenne des avis
        return note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
