package by.bsu.dao;

import by.bsu.entities.user.User;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yauheniya_Neliub on 2/24/2015.
 */
public class UserDao implements IUserDao {
    private SessionFactory sessionFactory;

    @Override
    public User findUserByLogin(String login) throws DaoException {
        List<User> users = new ArrayList<>();
        users = getSessionFactory().getCurrentSession()
                .createQuery("from User where login=?")
                .setParameter(0, login).list();
        if (users.size() > 0) {
            return users.get(0);
        } else {
             throw new DaoException("No user with such name");
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
