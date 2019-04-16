package com.pinchuk.resthotelbooking.service;

import com.pinchuk.resthotelbooking.domain.User;

public interface UserService {
	
	User getUserById(Long userId);
	
	User create(User user);

}
