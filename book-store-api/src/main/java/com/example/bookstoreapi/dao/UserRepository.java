package com.example.bookstoreapi.dao;

import com.example.bookstoreapi.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUserName(String userName);
}
