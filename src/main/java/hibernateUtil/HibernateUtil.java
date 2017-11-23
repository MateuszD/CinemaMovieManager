package hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void closeSession(){
        sessionFactory.close();
    }
}
