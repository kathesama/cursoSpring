package com.kathe.springboot.app.controllers.section02;

import com.kathe.springboot.app.models.section02.User;
import com.kathe.springboot.app.models.section02.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserRESTController {
    @GetMapping("/detailsExample")
    // Alternate way: @RequestMapping(path="/details", method = RequestMethod.GET)
    public Map<String, Object> detailsExample() {
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Details str");
        body.put("firstName", "Fulano");
        body.put("lastName", "Detal");

        return body;
    }

    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Kathe", "Aguirre", "");

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Return USER details");
        body.put("firstName", user.getFirstName());
        body.put("lastName", user.getLastName());

        return body;
    }

    @GetMapping("/detailsDTO")
    public UserDTO detailsDTO() {
        Map<String, Object> body = new HashMap<>();
        UserDTO userDto = new UserDTO();
        User user = new User("Kathe", "Aguirre", "");

        userDto.setTitle("New title");
        userDto.setUser(user);

        return userDto;
    }

    @GetMapping("/listDTO")
    public List<User> detailsListDTO() {
        Map<String, Object> body = new HashMap<>();
        UserDTO userDto = new UserDTO();
        User user = new User("Kathe", "Aguirre", "");

        User user2 = new User("Estefania", "Martinez");

//        userDto.setTitle("New title");
//        userDto.setUser(user);

        //List<User> users = Arrays.asList(user, user2);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        return users;
    }
}
