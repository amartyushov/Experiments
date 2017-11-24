package io.mart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aleksandr Martiushov.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomePage() {
        return "main-page";
    }
}
