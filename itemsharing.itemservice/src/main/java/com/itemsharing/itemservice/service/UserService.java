package com.itemsharing.itemservice.service;

import com.itemsharing.itemservice.pojo.User;

public interface UserService {

    User findByUsername(String username);
}
