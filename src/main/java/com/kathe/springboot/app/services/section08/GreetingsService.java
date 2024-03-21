package com.kathe.springboot.app.services.section08;

import com.kathe.springboot.app.interfaces.section08.GreetingsInterface;
import org.springframework.stereotype.Service;

@Service
public class GreetingsService implements GreetingsInterface {
    @Override
    public String sayHello(String person, String phrase) {
        return phrase + " " + person;
    }
}
