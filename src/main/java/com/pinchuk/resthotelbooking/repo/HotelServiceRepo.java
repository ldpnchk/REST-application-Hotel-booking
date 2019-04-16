package com.pinchuk.resthotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinchuk.resthotelbooking.domain.HotelService;

public interface HotelServiceRepo  extends JpaRepository<HotelService, Long> {

}
