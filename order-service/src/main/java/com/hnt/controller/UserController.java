package com.hnt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.User;
import com.hnt.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController 
public class UserController extends BaseController {
	@Autowired
	UserService userService;

	@GetMapping
	String getUser() {
		return "test";
	}

	@GetMapping("/user/id")
	User getUserById(@Valid @PathVariable("id") Integer id) {
		return userService.getUser(id);

	}

	@GetMapping("/user/id/{id}")
	@ResponseStatus
	ResponseEntity getResponseEntity(@Valid  @PathVariable("id") Integer id) {
		userService.getUser(id);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("header from server", "success");
		ResponseEntity reponseEntity = new ResponseEntity<>(headers, HttpStatus.CREATED);
		return reponseEntity;
	}

	@PostMapping
	void saveUser(@RequestBody User user) {
		userService.save(user);
		log.debug(user.getName());
	}

	@PostMapping("/user")
	Integer saveUserMethod(@RequestBody User user) {
		userService.save(user);
		return user.getId();
	}
}
