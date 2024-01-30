package com.kathe.springboot.app.models.section05;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class CustomError {
    private String message;
    private String errorMessage;
    private int status;
    private Date date;
}
