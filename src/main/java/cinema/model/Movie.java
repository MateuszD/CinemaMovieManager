package cinema.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    int movieId;

    @Column(name = "movie_title")
    String movieTitle;

    @Column(name = "movie_director")
    String movieDirector;

    @Column(name = "movie_genre")
    String movieGenre;

    @Column(name = "movie_productiondate")
    LocalDate movieProductionDate;


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public LocalDate getMovieProductionDate() {
        return movieProductionDate;
    }

    public void setMovieProductionDate(LocalDate movieProductionDate) {
        this.movieProductionDate = movieProductionDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", movieProductionDate=" + movieProductionDate +
                '}';
    }
}
