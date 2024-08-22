package eni.tp.app.eni_app.bo;

public class Movie {

    public Long id;
    public String title;
    // Temporaire => Plus tard les notes = associations avis
    public int note = 2;

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

    /**
     * Récupère la note sur un format int
     * @return
     */
    public int getNote() {
        // Plus tard quand on va supprimer le int note
        // La note sera la moyenne des avis
        return note;
    }
}
