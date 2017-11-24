package io.mart.validation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Aleksandr Martiushov.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder //preprocessor for requests
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showFormMethod(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processFormMethod(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult bindingResult) {
        System.out.println("|"+theCustomer.getLastName()+"|");

        System.out.println("Binding results: + " + bindingResult);
        System.out.println("\n\n\n\n\n");

        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
