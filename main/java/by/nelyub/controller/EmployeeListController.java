package by.nelyub.controller;

import by.nelyub.entities.Company;
import by.nelyub.entities.Employee;
import by.nelyub.exception.TechnicalException;
import by.nelyub.service.DBService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static by.nelyub.constant.ControllerConstants.*;

/**
 * Class of controller,  which processes http request and send to the page with result or error page
 */
@Controller
public class EmployeeListController {
    public static final Logger LOGGER = Logger.getLogger(EmployeeListController.class);
    private DBService service;

    public void setService(DBService service) {
        this.service = service;
    }

    /**
     * Insert in all tables of database 10 000 columns and print how much time it took.
     */
    @RequestMapping(value = "/generateDB")
    public String generateCountry(HttpServletRequest request) {
        long startTime = System.currentTimeMillis();
        service.insert();
        long endTime = System.currentTimeMillis();
        HttpSession session = request.getSession();
        StringBuilder message = new StringBuilder(MESASGE_GENERATE_DB);
        message.append((endTime - startTime) / 1000).append(MESASGE_SECONDS);
        session.setAttribute(PARAM_MESSAGE, message);
        return PAGE;
    }

    /**
     * Cleans database and print how much time it took.
     */
    @RequestMapping(value = "/cleanDB")
    public String clean(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(PARAM_EMPLOYEES_LIST);
        long startTime = System.currentTimeMillis();
        service.cleanDatabase();
        long endTime = System.currentTimeMillis();
        StringBuilder message = new StringBuilder(MESASGE_CLEAN_DB);
        message.append((endTime - startTime) / 1000).append(MESASGE_SECONDS);
        session.setAttribute(PARAM_MESSAGE, message);
        return PAGE;
    }

    /**
     * Gets rows about employees and sent it to the page,  which prints all information about this employees.
     */
    @RequestMapping(value = "/list")
    public String list(@RequestParam(value = "from", required = false) int from,
                       @RequestParam("size") int size,
                       HttpServletRequest request) throws TechnicalException {
        List<Employee> employees = service.getList(from, size);
        Set<Long> idSet = new HashSet<Long>();
        for (Employee employee : employees) {
            for (Company company : employee.getCompanies()) {
                idSet.add(company.getId());
            }
        }
        Map<Long, Integer> countMap = service.getEmployeesCount(idSet);
        HttpSession session = request.getSession();
        session.setAttribute(PARAM_EMPLOYEES_LIST, employees);
        session.setAttribute(PARAM_COUNT_EMPLOYEE, countMap);
        return PAGE;
    }

    /**
     * Hadles by.nelyub.exception.TechnicalException
     */

    @ExceptionHandler(TechnicalException.class)
    public ModelAndView handleTechnicalException(TechnicalException e) {
        LOGGER.error(e.getMessage(), e);
        ModelAndView model = new ModelAndView(ERROR_PAGE);
        model.addObject(PARAM_ERROR_MESASGE, e.getMessage());
        return model;
    }

}
