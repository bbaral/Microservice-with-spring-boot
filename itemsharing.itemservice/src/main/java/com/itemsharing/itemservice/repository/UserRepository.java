package com.itemsharing.itemservice.repository;

import com.itemsharing.itemservice.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
