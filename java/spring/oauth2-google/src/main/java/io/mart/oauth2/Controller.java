package io.mart.oauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping("/restricted")
	public String restricted() {
		return "I am restricted";
	}
}
