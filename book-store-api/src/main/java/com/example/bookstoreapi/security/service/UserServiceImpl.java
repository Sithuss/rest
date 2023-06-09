package com.example.bookstoreapi.security.service;

import com.example.bookstoreapi.dao.UserRepository;
import com.example.bookstoreapi.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findUserByUserName(userName).orElse(null);

    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
