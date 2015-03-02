package by.bsu.dao;

import by.bsu.entities.user.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yauheniya_Neliub on 2/24/2015.
 */
public class UserDao implements IUserDao {
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String username) throws DaoException {
        try {
            List<User> users = new ArrayList<>();
            Session session = sessionFactory.getCurrentSession();
            //Query query = session.createQuery("from User u where u.login=:login")
                  //  .setParameter("login", login);
            users = session.createQuery("from User").list();
            System.out.println("USers"+users.size());
            if (users.size() > 0) {
                return users.get(0);
            } else {
                throw new DaoException("No user with such name");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage(), e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
