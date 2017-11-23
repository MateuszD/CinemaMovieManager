package cinema.presenter;

import cinema.controllers.CinemaMainWindowController;
import cinema.model.DAO.MovieDao;
import cinema.model.Movie;
import cinema.presenter.presenterInteface.PresenterInterface;

import java.util.List;


public class CinemaProjectPresenter implements PresenterInterface {

    MovieDao movieDao = new MovieDao();
    CinemaMainWindowController cinemaMainWindowController;

    public CinemaProjectPresenter(CinemaMainWindowController cinemaMainWindowController) {
        this.cinemaMainWindowController = cinemaMainWindowController;
    }

    @Override
    public void addMovieToDatabase(Movie movie) {
        movieDao.addMovie(movie);
    }

    @Override
    public void removeMovieFromDatabase(Movie movie, int index) {
        movieDao.removeMovie(movie, index);
    }

    @Override
    public List<Movie> showMovieList() {
        return movieDao.getMovieList();
    }
}
