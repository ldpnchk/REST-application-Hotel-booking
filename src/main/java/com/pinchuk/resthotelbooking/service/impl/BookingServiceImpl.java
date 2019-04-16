package com.pinchuk.resthotelbooking.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinchuk.resthotelbooking.domain.Booking;
import com.pinchuk.resthotelbooking.domain.BookingDto;
import com.pinchuk.resthotelbooking.domain.HotelService;
import com.pinchuk.resthotelbooking.exceptions.InvalidInputException;
import com.pinchuk.resthotelbooking.exceptions.ResourceNotFoundException;
import com.pinchuk.resthotelbooking.repo.BookingRepo;
import com.pinchuk.resthotelbooking.service.BookingService;
import com.pinchuk.resthotelbooking.service.HotelServiceService;
import com.pinchuk.resthotelbooking.service.RoomService;
import com.pinchuk.resthotelbooking.service.UserService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private HotelServiceService hotelServiceService;
	
	@Autowired
	private BookingRepo bookingRepository;
	
	
	@Override
	public Booking create(BookingDto bookingDto) {
		if (ChronoUnit.DAYS.between(bookingDto.getStartDate(), bookingDto.getEndDate()) < 1){
    		throw new InvalidInputException();
		}
		if (bookingDto.getStartDate().isBefore(LocalDate.now())){
			throw new InvalidInputException();
		}
		
		Booking booking = new Booking();
		booking.setStartDate(bookingDto.getStartDate());
		booking.setEndDate(bookingDto.getEndDate());
		booking.setUser(userService.getUserById(bookingDto.getUserId()));
		booking.setRoom(roomService.getRoomById(bookingDto.getRoomId()));
		if (bookingDto.getHotelServiceIds() != null && bookingDto.getHotelServiceIds().size() > 0) {
			List<HotelService> hotelServices = hotelServiceService.getAllById(bookingDto.getHotelServiceIds());
			booking.setHotelServices(hotelServices);
		}
		booking = bookingRepository.save(booking);
		return booking;
	}
	
	@Override
	public BigDecimal getTotalPrice(Long bookingId){
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		
		if (!booking.isPresent()) {
			throw new ResourceNotFoundException();
		}

		BigDecimal totalPrice = booking.get().getRoom().getPrice()
				.multiply(new BigDecimal(ChronoUnit.DAYS.between(booking.get().getStartDate(), booking.get().getEndDate())));
				
		for (HotelService hotelService : booking.get().getHotelServices()) {
			totalPrice = totalPrice.add(hotelService.getPrice());
		}
		
		totalPrice = totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);

		return totalPrice;
	}

	@Override
	public List<Booking> getByUser(Long userId) {
		return bookingRepository.findByUser(userService.getUserById(userId));
	}

	@Override
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

}
