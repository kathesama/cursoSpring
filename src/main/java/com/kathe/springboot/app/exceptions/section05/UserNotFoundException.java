package com.kathe.springboot.app.exceptions.section05;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
    @NonNull
    private final String message;
}
