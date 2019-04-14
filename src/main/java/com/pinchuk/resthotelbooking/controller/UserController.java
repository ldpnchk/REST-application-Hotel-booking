package com.pinchuk.resthotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinchuk.resthotelbooking.domain.Greeting;
import com.pinchuk.resthotelbooking.repo.GreetingRepo;

@RestController
@RequestMapping("/test")
public class UserController {
	
	@Autowired
	private GreetingRepo greetingRepo;
	
	// 1. Run as simple Application (RestHotelBookingApplication.main())
	// 2. http://localhost:8080/test/sayHello?name=Lidiia
	
	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public Greeting sayHello(@RequestParam(value="name", required = true) String name) {
		Greeting greeting = new Greeting(1, name);
		return greeting;
	}
	
	// http://localhost:8080/test/getAll
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Greeting> getAll() {
		List<Greeting> greetings = greetingRepo.findAll();
		return greetings;
	}

}
