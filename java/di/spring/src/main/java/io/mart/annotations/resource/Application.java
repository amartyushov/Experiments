package io.mart.annotations.resource;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Aleksandr Martiushov
 * Standard @Resource annotation marks a resource that is needed by the application.
 * It is analogous to @Autowired in that both injects beans by type
 * when no attribute provided.
 * But with name attribute, @Resource allows you to inject a bean by it’s name, which @Autowired does not.
 */
@Component("application")
public class Application {

    @Resource(name="applicationUser")
    private ApplicationUser user;

    @Override
    public String toString() {
        return "Application [user=" + user + "]";
    }
}

