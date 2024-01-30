package com.kathe.springboot.app.services.section05;

import com.kathe.springboot.app.exceptions.section05.UserNotFoundException;
import com.kathe.springboot.app.interfaces.section05.UserServiceInt;
import com.kathe.springboot.app.models.section05.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
class UserServiceImpl implements UserServiceInt {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final List<User> users;

    public UserServiceImpl(){
        this.users = Arrays.asList(
                new User(1L, "Pepe", "Aguilar"),
                new User(2L, "Maria", "Paleta"),
                new User(3L, "Juan", "Doe")
        );
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new UserNotFoundException("Error el usuario no existe!"));
    }
}
