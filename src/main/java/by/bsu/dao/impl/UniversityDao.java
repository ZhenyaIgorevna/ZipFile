package by.bsu.dao.impl;

import by.bsu.dao.DaoException;
import by.bsu.dao.IUniversityDao;
import by.bsu.entities.univer.University;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 06.04.2015.
 */
public class UniversityDao implements IUniversityDao {
    private SessionFactory sessionFactory;

    @Override
    public List<University> getAllUniversity() throws DaoException {
        List<University> universities = new ArrayList<University>();
        try{
            final Session session = sessionFactory.getCurrentSession();
            universities = session.createQuery("from University").list();
            return universities;
        }catch (HibernateException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public void insertUniversity(University university) throws DaoException {
        try{
            final Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(university);
        }catch (HibernateException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<University> getUniversityByName(String name) throws DaoException {
        List<University> universities = null;
        try{
            final Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(University.class);
            criteria.add(Restrictions.eq("name", name));
            universities = criteria.list();
            return universities;
        }catch (HibernateException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public void removeUniversity(final University university)throws DaoException{
        try{
            final Session session = sessionFactory.getCurrentSession();
            session.delete(university);
        }catch (HibernateException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
