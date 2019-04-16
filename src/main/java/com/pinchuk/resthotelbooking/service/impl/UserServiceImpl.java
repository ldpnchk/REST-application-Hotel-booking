package com.pinchuk.resthotelbooking.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinchuk.resthotelbooking.domain.User;
import com.pinchuk.resthotelbooking.exceptions.ResourceNotFoundException;
import com.pinchuk.resthotelbooking.repo.UserRepo;
import com.pinchuk.resthotelbooking.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserRepo userRepository;

	@Override
	public User getUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw new ResourceNotFoundException();
		}
		
		return user.get();
	}
	
	@Override
	public User create(User user) {
		User userSaved = userRepository.save(user);
		return userSaved;
	}

}
