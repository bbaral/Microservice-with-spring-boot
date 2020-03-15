package com.itemsharing.userservice.service;

import com.itemsharing.userservice.service.pojo.User;

public interface UserService {

    User createUser(User user);
    User getUserByUserName(String username);
}
