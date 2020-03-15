package com.itemsharing.userservice.repository;

import com.itemsharing.userservice.service.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
