package com.hnt;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hnt.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value = "Select * from user u where u.name =:name", nativeQuery = true)
	User findByName(@Param("name") String name);

}
