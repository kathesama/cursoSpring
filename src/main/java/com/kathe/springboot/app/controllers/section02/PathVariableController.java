package com.kathe.springboot.app.controllers.section02;

import com.kathe.springboot.app.models.section02.User;
import com.kathe.springboot.app.models.section02.dto.ParamDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/params")
public class PathVariableController {
    @Autowired
    private Environment environment;

    @Value("${config.username}")
    private String username;

//    private String messageByEnv;

//    @Value("${config.valuesList}")
//    private String[] valuesList;

    @Value("#{ '${config.valuesList}'.split(',') }")
    private List<String> valuesList;

    @Value("#{ ${config.valuesMap} }")
    private Map<String, Object> valuesMap;

    @GetMapping("/pathVariable/{message}/{value}")
    public ParamDTO pathVariable(@PathVariable String message, @PathVariable String value) {
        ParamDTO param = new ParamDTO();

        return getParamDTO(message, value, param);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> getValues(@Value("${config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("idParseInline", environment.getProperty("config.id", Long.class));
        json.put("idParseOutline", Long.valueOf(Objects.requireNonNull(environment.getProperty("config.id"))));
        json.put("username",username);
        json.put("message",message);
        json.put("messageByEnv",environment.getProperty("config.message"));
        json.put("valuesList", valuesList);
        json.put("valuesMap", valuesMap);

        return json;
    }

    static ParamDTO getParamDTO(String message, String value, ParamDTO param) {
        if (message == null || value == null) {
            throw new IllegalArgumentException("Los parámetros 'message' y/o 'value' no pueden ser null.");
        }

        try {
            int intValue = Integer.parseInt(value);
            param.setValue(intValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El parámetro 'value' debe ser un número válido.");
        }

        param.setMessage(message);

        return param;
    }
}
