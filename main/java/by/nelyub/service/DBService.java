package by.nelyub.service;

import by.nelyub.dao.CompaniesDao;
import by.nelyub.entities.Employee;
import by.nelyub.exception.DaoException;
import by.nelyub.exception.TechnicalException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class for working with database.
 */
public class DBService {
    private CompaniesDao companiesDao;

    public void setCompaniesDao(CompaniesDao companiesDao) {
        this.companiesDao = companiesDao;
    }

    /**
     * Inserts rows into database
     *
     * @throws TechnicalException if there is problem with dao.
     */
    public void insert() throws TechnicalException {
        try {
            companiesDao.insert();
        } catch (DaoException e) {
            throw new TechnicalException(e.getMessage(), e);
        }
    }

    /**
     * Cleans database.
     *
     * @throws TechnicalException if there is problem with dao.
     */
    public void cleanDatabase() throws TechnicalException {
        try {
            companiesDao.clean();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new TechnicalException(e.getMessage(), e);
        }
    }

    /**
     * Gets list of employees
     *
     * @return getting list
     * @throws TechnicalException if there is problem with dao.
     */
    public List<Employee> getList(int from, int size) throws TechnicalException {
        try {
            return companiesDao.getList(from, size);
        } catch (DaoException e) {
            throw new TechnicalException(e.getMessage(), e);
        }
    }

    /**
     * Gets maps with id of company and count of employees working in this company.
     * @param idSet set with id of company
     * @return maps with id of company and count of employees working in this company
     * @throws TechnicalException  if there is problem with dao.
     */
    public Map<Long, Integer> getEmployeesCount(Set<Long> idSet) throws TechnicalException {
        try {
            return companiesDao.getEmployeeCount(idSet);
        } catch (DaoException e) {
            throw new TechnicalException(e.getMessage(), e);
        }
    }
}
