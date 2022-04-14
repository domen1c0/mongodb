package com.estudo.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.mongodb.domain.User;
import com.estudo.mongodb.repositories.UserRepository;

@Service
public class UserService   {
	
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	

}
