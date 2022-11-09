package com.spring.boot.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.validation.dto.UserRequest;
import com.spring.boot.validation.entity.User;
import com.spring.boot.validation.exception.UserNotFoundException;
import com.spring.boot.validation.repository.UserRepositoy;


@Service
public class UserService {
	
	@Autowired
	private UserRepositoy userRepositoy;
	
	// save user
	public User saveUser(UserRequest userRequest) {
		User user = User.
                build(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		
		return userRepositoy.save(user);
		
	}
	
	// get all users
	public List<User> getAllUsers(){
		return userRepositoy.findAll();
	}
	
	// get single user
	public User getUser(int id) throws UserNotFoundException {
        User user= userRepositoy.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }

}
