package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.security.model.Role;
import com.example.bookstoreapi.security.model.User;
import com.example.bookstoreapi.security.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    record RequestUser(String name, @JsonProperty("user_name") String userName, String password) {}

    record ResponseUser(int id, @JsonProperty("user_name") String userName){}


    @PostMapping("/user/register")
    public ResponseEntity<?> register(@RequestBody RequestUser requestUser) {
        if (userService.findByUsername(requestUser.userName()) != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        var savedUser = userService.saveUser(new User(requestUser.name(),
                requestUser.userName(),
                requestUser.password(),
                Role.USER));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseUser(savedUser.getId(), savedUser.getUserName()));
    }
}
