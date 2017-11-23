package cinema.presenter.presenterInteface;

import cinema.model.Movie;

import java.util.List;

public interface PresenterInterface {

    public void addMovieToDatabase(Movie movie);

    public void removeMovieFromDatabase(Movie movie, int index);

    public List<Movie> showMovieList();

}
