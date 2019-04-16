package com.pinchuk.resthotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinchuk.resthotelbooking.domain.RoomCategory;

public interface RoomCategoryRepo extends JpaRepository<RoomCategory, Long> {

}
