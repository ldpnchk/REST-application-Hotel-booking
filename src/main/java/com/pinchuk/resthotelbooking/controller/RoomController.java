package com.pinchuk.resthotelbooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinchuk.resthotelbooking.domain.Room;
import com.pinchuk.resthotelbooking.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = "/getAvailableRooms", method = RequestMethod.GET)
	public List<Room> getAvailableRooms(@RequestParam(value = "startDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, 
										@RequestParam(value = "endDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {	
		return roomService.getFreeRoomsByDates(startDate, endDate);
	}
	
	@RequestMapping(value = "/getRoomsByCategory", method = RequestMethod.GET)
	public List<Room> getRoomsByCategory(@RequestParam(value = "categoryId", required = true) Long categoryId) {	
		return roomService.getByRoomCategory(categoryId);
	}
	
}
