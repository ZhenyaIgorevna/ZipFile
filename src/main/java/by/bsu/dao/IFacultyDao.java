package by.bsu.dao;

import by.bsu.entities.univer.Faculty;

import java.util.List;

/**
 * Created by Zhenya on 06.04.2015.
 */
public interface IFacultyDao {
    List<Faculty> getAllFacultiesOfUniver(final int univerId) throws DaoException;
    void insertFaculty(final Faculty faculty) throws DaoException;
    List<Faculty> getUniverFacultyByName(final String name, final int univerId) throws DaoException;
    void removeFaculty(final Faculty faculty) throws DaoException;
}
