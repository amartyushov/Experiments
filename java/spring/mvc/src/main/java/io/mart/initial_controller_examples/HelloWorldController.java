package io.mart.initial_controller_examples;

import org.springframework.web.servlet.mvc.AbstractController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * http://localhost:8080/spring2/welcome.htm
 * @author Aleksandr Martiushov
 */
public class HelloWorldController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        // To identify which view should return back to the user, in this example HelloWorldPage.jsp will be returned.
        ModelAndView model = new ModelAndView("HelloWorldPage");

        // Add a “hello world” string into a model named “msg”
        model.addObject("msg", "hello world");

        return model;
    }
}
