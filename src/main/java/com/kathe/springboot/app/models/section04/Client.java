package com.kathe.springboot.app.models.section04;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Client {
    @Value("${client.name}")
    private String name;

    @Value("${client.lastName}")
    private String lastName;
}
