package com.hnt.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.entity.User;
import com.hnt.service.UserService;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {
  
	@Mock
	UserService service;
	
	@InjectMocks
	UserController controller;
	@Test
	void test() {
		User user = new User();
		user.setId(1);
		user.setName("John");
		user.setAge(23);
		when(service.save(user)).thenReturn(user);
		assertEquals(user.getId(),1);;
		
	}
	

}
