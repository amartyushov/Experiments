package io.mart.initial_controller_examples;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aleksandr Martiushov.
 */
@Controller
public class RegisterController {

    @RequestMapping("/register")
    public String showForm() {
        return "register-form";
    }

    @RequestMapping("/processForm")
    public String processFormMethod() {
        return "registration-result";
    }

    @RequestMapping("/processFormUppercase")
    public String shoutLoud(HttpServletRequest request, Model model) {

        String studentName = request.getParameter("studentName");
        studentName = studentName.toUpperCase();

        String result = "Yo! " + studentName;

        model.addAttribute("message", result);
        return "registration-result";
    }

    @RequestMapping("/processFormUppercaseWithRequestParam")
    public String shoutLoudWithRequestParam(@RequestParam("studentName") String theName, Model model) {


        theName = theName.toUpperCase();

        String result = "Using request parameter: " + theName;

        model.addAttribute("message", result);
        return "registration-result";
    }

}
