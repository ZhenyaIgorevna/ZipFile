package by.bsu.controller;

import by.bsu.entities.univer.Faculty;
import by.bsu.entities.univer.University;
import by.bsu.service.IFacultyService;
import by.bsu.service.IUniversityService;
import by.bsu.service.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Yauheniya_Neliub on 2/27/2015.
 */
@Controller
public class AdminController {
    private IFacultyService facultyService;
    private IUniversityService universityService;

    private static final Logger LOGGER = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "addUniver")
    public String addUniversity(@RequestParam("univerName") String univerName,
                                @RequestParam("facultyName") String facultyName) {
        final University university = new University(univerName);
        final Faculty faculty = new Faculty(facultyName, university);
        try{
            facultyService.insertFaculty(faculty);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage());
        }
        return "success";
    }

    public void setFacultyService(IFacultyService facultyService) {
        this.facultyService = facultyService;
    }

    public void setUniversityService(IUniversityService universityService) {
        this.universityService = universityService;
    }
}
