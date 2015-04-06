package by.bsu.service.impl;

import by.bsu.dao.DaoException;
import by.bsu.dao.IFacultyDao;
import by.bsu.entities.univer.Faculty;
import by.bsu.entities.univer.University;
import by.bsu.service.IFacultyService;
import by.bsu.service.ServiceException;

import java.util.List;

/**
 * Created by Zhenya on 06.04.2015.
 */
public class FacultyService implements IFacultyService{
    private IFacultyDao facultyDao;

    @Override
    public List<Faculty> getAllFacultiesOfUniver(int univerId) throws ServiceException {
        try{
            List<Faculty> faculties = facultyDao.getAllFacultiesOfUniver(univerId);
            return  faculties;
        }catch (DaoException e){
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public void insertFaculty(Faculty faculty) throws ServiceException {
        try{
            facultyDao.insertFaculty(faculty);
        }catch (DaoException e){
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Faculty getUniverFacultyByName(String name, int univerId) throws ServiceException {
        try{
            List<Faculty> faculties = facultyDao.getUniverFacultyByName(name, univerId);
            if(faculties.size() == 1) {
                return faculties.get(0);
            }else{
                throw new ServiceException("There are several faculties with such name");
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public void removeFaculty(Faculty faculty) throws ServiceException {
        try{
            facultyDao.removeFaculty(faculty);
        }catch (DaoException e){
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public boolean fetchFaculty(String name, int univerId) throws ServiceException {
        try{
            List<Faculty> faculties = facultyDao.getUniverFacultyByName(name, univerId);
            if(faculties.size() == 1) {
                return true;
            }else if(faculties.size() == 0){
                return false;
            }else{
                throw new ServiceException("There are several faculties with such name");
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    public IFacultyDao getFacultyDao() {
        return facultyDao;
    }

    public void setFacultyDao(IFacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }
}
