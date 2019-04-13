package com.marom.gallerybackend.services;

import com.marom.gallerybackend.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findByUserName(String userName);

    User save(User user);
}
