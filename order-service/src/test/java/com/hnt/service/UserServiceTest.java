package com.hnt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.UserRepository;
import com.hnt.entity.User;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@InjectMocks
	UserService service ;
	
	@Mock
	UserRepository repository;
	

	@Test
	void testUser() {
		User user = new User();
		user.setId(1);
		user.setName("John");
		user.setAge(23);
		when(repository.save(user)).thenReturn(user);
		service.save(user);
		assertEquals(user.getId(),1);
		
	}
	
	@Test
	void testName() {
		User user = new User();
		user.setName("John");
		when(repository.findByName(user.getName())).thenReturn(user);
		service.save(user);
		assertEquals(user.getName(),"John");
		
	}
	

}
