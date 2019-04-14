package com.pinchuk.resthotelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class RestHotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestHotelBookingApplication.class, args);
	}

}
