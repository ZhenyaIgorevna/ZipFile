package by.bsu.dao;

import by.bsu.entities.user.User;

/**
 * Created by Yauheniya_Neliub on 2/24/2015.
 */
public interface IUserDao {
    public User findUserByLogin(String login) throws DaoException;
}
