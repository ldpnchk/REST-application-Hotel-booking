package com.pinchuk.resthotelbooking.service;

import java.util.List;

import com.pinchuk.resthotelbooking.domain.HotelService;

public interface HotelServiceService {
	
	List<HotelService> getAllById(List<Long> hotelServiceIds);

}
