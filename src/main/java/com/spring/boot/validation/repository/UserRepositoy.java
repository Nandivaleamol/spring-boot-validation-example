package com.spring.boot.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.validation.entity.User;

public interface UserRepositoy extends JpaRepository<User, Integer> {
	
	User findByUserId(int id);

}
