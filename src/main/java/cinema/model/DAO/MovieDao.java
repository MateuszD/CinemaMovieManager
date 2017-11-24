package cinema.model.DAO;

import cinema.model.Movie;
import hibernateUtil.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MovieDao {

    public Integer addMovie(Movie movie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer movieID = null;

        try {
            transaction = session.beginTransaction();
            movieID = (Integer) session.save(movie);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }


        session.close();

        return movieID;
    }

    public List<Movie> getMovieList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Movie> movieList = null;

        transaction = session.beginTransaction();
        movieList = session.createQuery("FROM Movie ").list();
        transaction.commit();

        session.close();
        return movieList;
    }

    public void removeMovie(Movie movie, Integer id) {
        if (movie.getMovieId() == 0) {
            return;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(session.get(Movie.class, id));
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

}
