package com.pinchuk.resthotelbooking.domain;

import java.time.LocalDate;
import java.util.List;

public class BookingDto {

	private LocalDate startDate;
	private LocalDate endDate;
	private Long userId;
	private Long roomId;
	private List<Long> hotelServiceIds;
	
	public BookingDto() {
		
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public List<Long> getHotelServiceIds() {
		return hotelServiceIds;
	}

	public void setHotelServiceIds(List<Long> hotelServiceIds) {
		this.hotelServiceIds = hotelServiceIds;
	}
	
}
