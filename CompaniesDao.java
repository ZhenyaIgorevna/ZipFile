package by.nelyub.dao;

import by.nelyub.entities.*;
import by.nelyub.exception.DaoException;
import by.nelyub.service.ServiceGenerator;
import org.hibernate.*;

import java.util.*;

/**
 * Class for work with database using Hibernate.
 */
public class CompaniesDao {

    private SessionFactory sessionFactory;
    private static final String HQL_DELETE_COMPANY_QUERY = "Delete from Company";
    private static final String HQL_DELETE_EMPLOYEE_QUERY = "Delete from Employee";
    private static final String HQL_DELETE_ADDRESS_QUERY = " Delete from Address";
    private static final String HQL_DELETE_CITY_QUERY = " Delete from City";
    private static final String HQL_DELETE_COUNTRY_QUERY = " Delete from Country";
    private static final String HQL_GET_LIST_COUNTRY_QUERY = "from Country";
    private static final String HQL_GET_LIST_CITY_QUERY = "from City";
    private static final String HQL_GET_LIST_ADDRESS_QUERY = "from Address";
    private static final String HQL_GET_LIST_EMPLOYEE_QUERY = "from Employee";
    private static final String SQL_DELETE_EMPLOYEE_COMPANY_QUERY = "DELETE FROM EMPLOYEE_COMPANY";
    private static final String SQL_DELETE_ADDRESS_COMPANY_QUERY = "DELETE FROM ADDRESS_COMPANY";
    private static final String SQL_GET_COUNT_EMPLOYEE_QUERY = "select count(EMPLOYEE_ID) from EMPLOYEE_COMPANY where COMPANY_ID = :companyId";
    private static final String PARAM_COMPANY_ID = "companyId";

    private ServiceGenerator serviceGenerator = new ServiceGenerator();

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Gets list of 100 first employees.
     *
     * @return getting list of employees
     * @throws DaoException indicates an issue locating a suitable current session or can't get objects.
     */
    //@Transactional
    public List<Employee> getList(int from, int size) throws DaoException {
        Session session;
        Transaction transaction = null;
        try {
            long start = System.currentTimeMillis();
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(HQL_GET_LIST_EMPLOYEE_QUERY);
            query.setFirstResult(from - 1);
            query.setMaxResults(size);
            List<Employee> employees = query.list();
            transaction.commit();
            long end = System.currentTimeMillis();
            System.out.println("Get " + size + " employees " + (end - start) + " milliseconds");
            return employees;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * Gets count of employees in company.
     *
     * @param idSet set og companies id.
     * @return maps with id of company and count of employees working in this company
     * @throws DaoException indicates an issue locating a suitable current session or can't get objects.
     */
    public Map<Long, Integer> getEmployeeCount(Set<Long> idSet) throws DaoException {
        Map<Long, Integer> countMap = new HashMap<Long, Integer>();
        Session session;
        Transaction transaction = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(SQL_GET_COUNT_EMPLOYEE_QUERY);
            for (Long id : idSet) {
                query.setParameter(PARAM_COMPANY_ID, id);
                List<Integer> countEmployee = query.list();
                countMap.put(id, countEmployee.get(0));
            }
            transaction.commit();
            return countMap;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * Cleans database
     *
     * @throws DaoException indicates an issue locating a suitable current session or can't update objects.
     */
    public void clean() throws DaoException {
        Session session;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            long start = System.currentTimeMillis();
            Query query = session.createSQLQuery(SQL_DELETE_EMPLOYEE_COMPANY_QUERY);
            query.executeUpdate();
            long end = System.currentTimeMillis();
            System.out.println("Clean EMPLOYEE_COMPANY: " + (end - start) + " milliseconds");

            start = System.currentTimeMillis();
            query = session.createSQLQuery(SQL_DELETE_ADDRESS_COMPANY_QUERY);
            query.executeUpdate();
            end = System.currentTimeMillis();
            System.out.println("Clean ADDRESS_COMPANY: " + (end - start) + " milliseconds");
            session.flush();
            session.clear();

            start = System.currentTimeMillis();
            query = session.createQuery(HQL_DELETE_COMPANY_QUERY);
            query.executeUpdate();
            end = System.currentTimeMillis();
            System.out.println("Clean COMPANY: " + (end - start) + " milliseconds");
            session.flush();
            session.clear();

            start = System.currentTimeMillis();
            query = session.createQuery(HQL_DELETE_EMPLOYEE_QUERY);
            query.executeUpdate();
            end = System.currentTimeMillis();
            System.out.println("Clean EMPLOYEE: " + (end - start) + " milliseconds");
            session.flush();
            session.clear();

            start = System.currentTimeMillis();
            query = session.createQuery(HQL_DELETE_ADDRESS_QUERY);
            query.executeUpdate();
            end = System.currentTimeMillis();
            System.out.println("Clean ADDRESS: " + (end - start) + " milliseconds");
            session.flush();
            session.clear();

            start = System.currentTimeMillis();
            query = session.createQuery(HQL_DELETE_CITY_QUERY);
            query.executeUpdate();
            end = System.currentTimeMillis();
            System.out.println("Clean CITY: " + (end - start) + " milliseconds");
            session.flush();
            session.clear();

            start = System.currentTimeMillis();
            query = session.createQuery(HQL_DELETE_COUNTRY_QUERY);
            query.executeUpdate();
            end = System.currentTimeMillis();
            System.out.println("Clean COUNTRY: " + (end - start) + " milliseconds");

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * Inserts in all tables of database 10 000 rows.
     *
     * @throws DaoException indicates an issue locating a suitable current session or can't update objects.
     */
    public void insert() throws DaoException {
        Session session;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            List<Country> countries = serviceGenerator.generateCountries();
            long start = System.currentTimeMillis();
            insertTable(countries, session);
            List<Country> insertedCountry = session.createQuery(HQL_GET_LIST_COUNTRY_QUERY).list();
            long end = System.currentTimeMillis();
            System.out.println("Insert COUNTRY: " + (end - start) + " milliseconds");

            start = System.currentTimeMillis();
            List<City> cities = serviceGenerator.generateCities(insertedCountry);
            insertTable(cities, session);
            List<City> insertedCity = session.createQuery(HQL_GET_LIST_CITY_QUERY).list();
            end = System.currentTimeMillis();
            System.out.println("Insert CITY: " + (end - start) + " milliseconds");

            start = System.currentTimeMillis();
            List<Address> addresses = serviceGenerator.generateAddresses(insertedCity);
            insertTable(addresses, session);
            List<Address> insertedAddress = session.createQuery(HQL_GET_LIST_ADDRESS_QUERY).list();
            end = System.currentTimeMillis();
            System.out.println("Insert ADDRESS: " + (end - start) + " milliseconds");

            start = System.currentTimeMillis();
            List<Employee> employees = serviceGenerator.generateEmployees(insertedAddress);
            insertTable(employees, session);
            List<Employee> insertedEmployees = session.createQuery(HQL_GET_LIST_EMPLOYEE_QUERY).list();
            end = System.currentTimeMillis();
            System.out.println("Insert EMPLOYEE: " + (end - start) + " milliseconds");

            start = System.currentTimeMillis();
            List<Company> companies = new ArrayList<Company>();
            companies.addAll(serviceGenerator.generateCompanies(insertedEmployees, insertedAddress));
            insertTable(companies, session);
            end = System.currentTimeMillis();
            System.out.println("Insert COMPANY: " + (end - start) + " milliseconds");

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException(e.getMessage(), e);
        }
    }

    private <T> void insertTable(List<T> list, Session session) {
        for (int i = 0; i < list.size(); i++) {
            T entity = list.get(i);
            session.save(entity);
            if (i % 50 == 0) {
                session.flush();
                session.clear();
            }
        }
    }


}
