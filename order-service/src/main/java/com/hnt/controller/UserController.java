package com.hnt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin
@RestController
public class UserController extends BaseController {
	@Autowired
	UserService userService;

	@GetMapping
	String getUser() {
		return "test";
	}

	@GetMapping("/user")
	Iterable<User> getAllUser() {
		return userService.getUser();
	}

	@GetMapping("/user/name/{name}")
	User getUserById(@Valid @PathVariable("name") String name) {
		return userService.getUserByName(name);

	}

	@PostMapping("/user/id/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	ResponseEntity getResponseEntity(@Valid @PathVariable("id") Integer id, User user) {
		User user1 = userService.getUser(id);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("header from server", "success");
		ResponseEntity reponseEntity = new ResponseEntity<>(user1, headers, HttpStatus.FOUND);
		return reponseEntity;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void saveUser(@RequestBody User user) {
		userService.save(user);
		log.debug(user.getName());
	}

	@PostMapping("/user")
	User saveUserMethod(@Valid @RequestBody User user) {
		userService.save(user);
		return user;
	}

	@DeleteMapping("user/{userid}")
	void deleteUser(@PathVariable("userid") int userid) {
		userService.delete(userid);

	}
}
