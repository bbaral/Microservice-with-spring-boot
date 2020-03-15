package com.itemsharing.userservice.Implementation;

import com.itemsharing.userservice.repository.UserRepository;
import com.itemsharing.userservice.security.SecurityUtility;
import com.itemsharing.userservice.service.UserService;
import com.itemsharing.userservice.service.pojo.Role;
import com.itemsharing.userservice.service.pojo.User;
import com.itemsharing.userservice.service.pojo.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null) {
            LOG.info("user with username {} already exist", user.getUsername());
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            Role localRole = new Role();
            localRole.setRoleId(1);
            userRoles.add(new UserRole(user, localRole));
            user.getUserRoles().addAll(userRoles);

            Date date = new Date();
            user.setJoinDate(date);

            //Encrypt the password
            String encryptPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
            user.setPassword(encryptPassword);
            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
