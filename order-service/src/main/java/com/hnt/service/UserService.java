package com.hnt.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.UserRepository;
import com.hnt.entity.User;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	public User save(User user) {
		return repository.save(user);
	}
	
	public User getUser(Integer userId)  {
		return repository.findById(userId).get();
		
	}
	
	public User getUserByName(String name)  {
		return repository.findByName(name);
		
	}
	

}
