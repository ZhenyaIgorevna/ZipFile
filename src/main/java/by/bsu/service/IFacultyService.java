package by.bsu.service;

import by.bsu.dao.DaoException;
import by.bsu.entities.univer.Faculty;

import java.util.List;

/**
 * Created by Zhenya on 06.04.2015.
 */
public interface IFacultyService {
    List<Faculty> getAllFacultiesOfUniver(final int univerId) throws ServiceException;
    void insertFaculty(final Faculty faculty) throws ServiceException;
    Faculty getUniverFacultyByName(final String name, final int univerId) throws ServiceException;
    void removeFaculty(final Faculty faculty) throws ServiceException;
    boolean fetchFaculty(final String name, final int univerId) throws ServiceException;

}
