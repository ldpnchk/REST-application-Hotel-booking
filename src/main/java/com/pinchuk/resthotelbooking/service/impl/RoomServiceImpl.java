package com.pinchuk.resthotelbooking.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinchuk.resthotelbooking.domain.Room;
import com.pinchuk.resthotelbooking.domain.RoomCategory;
import com.pinchuk.resthotelbooking.exceptions.InvalidInputException;
import com.pinchuk.resthotelbooking.exceptions.ResourceNotFoundException;
import com.pinchuk.resthotelbooking.repo.RoomRepo;
import com.pinchuk.resthotelbooking.service.RoomCategoryService;
import com.pinchuk.resthotelbooking.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomRepo roomRepository;
	
	@Autowired
	private RoomCategoryService roomCategoryService;

	@Override
	public Room getRoomById(Long roomId) {
		Optional<Room> room = roomRepository.findById(roomId);
		if (!room.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return room.get();
	}
	
	@Override
	public List<Room> getFreeRoomsByDates(LocalDate startDate, LocalDate endDate) {
		if (ChronoUnit.DAYS.between(startDate, endDate) < 1){
    		throw new InvalidInputException();
		}
		
		return roomRepository.findFreeRoomsByDates(startDate, endDate);
	}

	@Override
	public List<Room> getByRoomCategory(Long roomCategoryId) {
		RoomCategory roomCategory = roomCategoryService.getById(roomCategoryId);
		return roomRepository.findByRoomCategory(roomCategory);
	}

}
