package com.pinchuk.resthotelbooking.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinchuk.resthotelbooking.domain.RoomCategory;
import com.pinchuk.resthotelbooking.exceptions.ResourceNotFoundException;
import com.pinchuk.resthotelbooking.repo.RoomCategoryRepo;
import com.pinchuk.resthotelbooking.service.RoomCategoryService;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService{
	
	@Autowired
	private RoomCategoryRepo roomCategoryRepository;

	@Override
	public RoomCategory getById(Long roomCategoryId) {
		Optional<RoomCategory> roomCategory = roomCategoryRepository.findById(roomCategoryId);
		if (!roomCategory.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return roomCategory.get();
	}

}
