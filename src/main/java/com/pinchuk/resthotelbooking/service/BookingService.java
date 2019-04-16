package com.pinchuk.resthotelbooking.service;

import java.math.BigDecimal;
import java.util.List;

import com.pinchuk.resthotelbooking.domain.Booking;
import com.pinchuk.resthotelbooking.domain.BookingDto;
import com.pinchuk.resthotelbooking.exceptions.InvalidInputException;

public interface BookingService {
	
	Booking create(BookingDto booking);
	
	BigDecimal getTotalPrice(Long bookingId) throws InvalidInputException;
	
	List<Booking> getByUser(Long userId);
	
	List<Booking> getAll();

}
