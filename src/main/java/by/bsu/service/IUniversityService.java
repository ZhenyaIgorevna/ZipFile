package by.bsu.service;

import by.bsu.dao.DaoException;
import by.bsu.entities.univer.University;

import java.util.List;

/**
 * Created by Zhenya on 06.04.2015.
 */
public interface IUniversityService {
    List<University> getAllUniversity() throws ServiceException;
    void insertUniversity(final University university) throws ServiceException;
    University getUniversityByName(final String name) throws ServiceException;
    void removeUniversity(final University university)throws ServiceException;
    boolean fetchUniversity(final String name) throws ServiceException;
}
