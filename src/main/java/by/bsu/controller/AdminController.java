package by.bsu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Yauheniya_Neliub on 2/27/2015.
 */
@Controller
public class AdminController {
    @RequestMapping(value = "/add/university")
    public String addUniversity(){

        return "admin/add_university";
    }
}
