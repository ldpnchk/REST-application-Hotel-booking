package com.pinchuk.resthotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinchuk.resthotelbooking.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
