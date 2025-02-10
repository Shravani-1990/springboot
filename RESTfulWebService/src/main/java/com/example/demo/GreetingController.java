package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
 * 
 */
@RestController // The controller will ensure that the class will control how the object will be
				// used 2 it is done using two parts 1. get mapping 2. request param
public class GreetingController {
	/*
	 * s is a placeholder of runtime value for ex if user inputs abcd result will be
	 * hello abcd
	 */
	private static final String template = "Hello, %s!";
	/*
	 * AtomicLong is data type that will handle huge data
	 */
	private final AtomicLong atomicLong = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(atomicLong.incrementAndGet(), String.format(template, name));
	}

}


