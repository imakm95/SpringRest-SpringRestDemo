package com.ashwani.sprin_rest_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //It is an extension of @controller and it adds supports for Spring rest
@RequestMapping("/test")
public class HelloWorldService {
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}

}
