package com.itemsharing.userservice;

import com.itemsharing.userservice.service.UserService;
import com.itemsharing.userservice.service.pojo.Role;
import com.itemsharing.userservice.service.pojo.User;
import com.itemsharing.userservice.service.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Adams");
        user1.setUsername("jadams");
        user1.setPassword("password");
        user1.setEmail("jadams@gmail.com");

        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1);
    }
}
