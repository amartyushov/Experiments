package io.mart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ResponseBody String home() {
        return "Hello world";
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(path = "/json-validation", method = RequestMethod.GET)
    public @ResponseBody List<Response> jsonValidation() {
        return new ArrayList<Response>(){{
            add(new Response(
                    1,
                    "yourName",
                    10.10d,
                    Arrays.asList(),
                    new Dimensions(13.2D, 14.1D, 7.1D),
                    new WarehouseLocation(30.1D, -16.5D)));
            add(new Response(
                    2,
                    "yourName2",
                    20.10d,
                    Arrays.asList("tag12", "tag22"),
                    new Dimensions(23.2D, 24.1D, 27.1D),
                    new WarehouseLocation(20.1D, -26.5D)));
        }};
    }

    @RequestMapping(path = "/json-validation-simple", method = RequestMethod.GET)
    public @ResponseBody Response jsonValidationSimple() {
        return new Response(1, "yourName", 10.10d, Arrays.asList("tag1", "tag2"));
    }
}
