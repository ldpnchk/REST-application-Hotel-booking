package com.pinchuk.resthotelbooking.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinchuk.resthotelbooking.domain.Booking;
import com.pinchuk.resthotelbooking.domain.BookingDto;
import com.pinchuk.resthotelbooking.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Booking createBooking(@RequestBody BookingDto bookingDto) {
		return bookingService.create(bookingDto);
	}
	
	@RequestMapping(value = "/getTotalPrice", method = RequestMethod.GET)
	public BigDecimal getTotalPrice(@RequestParam(value = "bookingId", required = true) Long bookingId){
		return bookingService.getTotalPrice(bookingId);
	}
	
	@RequestMapping(value = "/getByUser", method = RequestMethod.GET)
	public List<Booking> getByUser(@RequestParam(value = "userId", required = true) Long userId){
		return bookingService.getByUser(userId);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Booking> getAll(){
		return bookingService.getAll();
	}

}
