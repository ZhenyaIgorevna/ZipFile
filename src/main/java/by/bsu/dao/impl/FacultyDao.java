package by.bsu.dao.impl;

import by.bsu.dao.DaoException;
import by.bsu.dao.IFacultyDao;
import by.bsu.entities.univer.Faculty;
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
public class FacultyDao implements IFacultyDao {
    private SessionFactory sessionFactory;

    @Override
    public List<Faculty> getAllFacultiesOfUniver(int univerId) throws DaoException {
        List<Faculty> faculties = new ArrayList<>();
        try {
            final Session session = sessionFactory.getCurrentSession();
            faculties = session.createQuery("from Faculty").list();
            return faculties;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public void insertFaculty(Faculty faculty) throws DaoException {
        try {
            final Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(faculty);
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Faculty> getUniverFacultyByName(String name , int univerId) throws DaoException {
        List<Faculty> faculties = null;
        try {
            final Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Faculty.class);
            criteria.add(Restrictions.eq("name", name));
            criteria.add(Restrictions.eq("un_id",univerId));
            faculties = criteria.list();
            return faculties;

        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public void removeFaculty(Faculty faculty) throws DaoException {
        try {
            final Session session = sessionFactory.getCurrentSession();
            session.delete(faculty);

        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
