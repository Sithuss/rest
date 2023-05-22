package com.example.bookstoreapi.security.service;

import com.example.bookstoreapi.security.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByUsername(String userName);

    List<User> findAllUser();
}
