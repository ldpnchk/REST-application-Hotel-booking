package com.pinchuk.resthotelbooking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinchuk.resthotelbooking.domain.HotelService;
import com.pinchuk.resthotelbooking.repo.HotelServiceRepo;
import com.pinchuk.resthotelbooking.service.HotelServiceService;

@Service
public class HotelServiceServiceImpl implements HotelServiceService{
	
	@Autowired 
	private HotelServiceRepo hotelServiceRepository;

	@Override
	public List<HotelService> getAllById(List<Long> hotelServiceIds) {
		return hotelServiceRepository.findAllById(hotelServiceIds);
	}

}
