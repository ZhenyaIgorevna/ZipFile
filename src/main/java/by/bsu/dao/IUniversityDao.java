package by.bsu.dao;

import by.bsu.entities.univer.University;

import java.util.List;

/**
 * Created by Zhenya on 06.04.2015.
 */
public interface IUniversityDao {
    List<University> getAllUniversity() throws DaoException;
    void insertUniversity(final University university) throws DaoException;
    List<University> getUniversityByName(final String name) throws DaoException;
    void removeUniversity(final University university)throws DaoException;
}
