package com.pinchuk.resthotelbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinchuk.resthotelbooking.domain.Booking;
import com.pinchuk.resthotelbooking.domain.User;

public interface BookingRepo extends JpaRepository<Booking, Long> {
	
	List<Booking> findByUser(User user);
	
	List<Booking> findAll();

}
