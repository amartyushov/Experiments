package io.mart.initial_controller_examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Aleksandr Martiushov.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptionsFromFile}")
    private Map<String, String> countryOptionsFromFile;

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);

        theModel.addAttribute("countryOptionsFromFile", countryOptionsFromFile);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processFormMethod(@ModelAttribute("student") Student theStudent) {
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
