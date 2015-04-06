package by.bsu.service.impl;

import by.bsu.dao.DaoException;
import by.bsu.dao.IUniversityDao;
import by.bsu.entities.univer.University;
import by.bsu.service.IUniversityService;
import by.bsu.service.ServiceException;

import java.util.List;

/**
 * Created by Zhenya on 06.04.2015.
 */
public class UniversityService implements IUniversityService{
    private IUniversityDao universityDao;

    @Override
    public List<University> getAllUniversity() throws ServiceException {
        try{
            List<University> universities = universityDao.getAllUniversity();
            return universities;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public void insertUniversity(University university) throws ServiceException {
        try{
            universityDao.insertUniversity(university);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public University getUniversityByName(String name) throws ServiceException {
        try{
            List<University> universities = universityDao.getUniversityByName(name);
            if(universities.size() == 1) {
                return universities.get(0);
            }else{
                throw new ServiceException("There are several university with such name");
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public void removeUniversity(University university) throws ServiceException {
        try{
            universityDao.removeUniversity(university);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    public IUniversityDao getUniversityDao() {
        return universityDao;
    }

    public boolean fetchUniversity(String name) throws ServiceException{
        try{
            List<University> universities = universityDao.getUniversityByName(name);
            if(universities.size() == 1) {
                return true;
            }else if(universities.size() == 0){
                return false;
            }
            else{
                throw new ServiceException("Such many university with this name...");
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    public void setUniversityDao(IUniversityDao universityDao) {
        this.universityDao = universityDao;
    }
}
