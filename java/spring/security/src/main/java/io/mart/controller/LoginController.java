package io.mart.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class LoginController {

    @GetMapping("/showMyLoginPage") // references to Security configuration
    public String showMyLoginPage() {
        //return "plain-login";
        return "fancy-login";
    }
}
