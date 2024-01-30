package com.kathe.springboot.app.interfaces.section05;

import com.kathe.springboot.app.models.section05.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInt {
    List<User> findAll();
//    Optional<User> findById(Long id);
    User findById(Long id);
}
