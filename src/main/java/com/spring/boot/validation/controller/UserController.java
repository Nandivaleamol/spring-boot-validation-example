package com.spring.boot.validation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.validation.dto.UserRequest;
import com.spring.boot.validation.entity.User;
import com.spring.boot.validation.exception.UserNotFoundException;
import com.spring.boot.validation.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	// add user
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}
	
	// get single user
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUser(id));
	}

	// get all user
    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
