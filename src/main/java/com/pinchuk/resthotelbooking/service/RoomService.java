package com.pinchuk.resthotelbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.pinchuk.resthotelbooking.domain.Room;

public interface RoomService {
	
	Room getRoomById(Long roomId);
	
	List<Room> getFreeRoomsByDates(LocalDate startDate, LocalDate endDate);
	
	List<Room> getByRoomCategory(Long roomCategoryId);

}
