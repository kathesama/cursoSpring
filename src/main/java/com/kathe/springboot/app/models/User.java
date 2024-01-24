package com.kathe.springboot.app.models;
import lombok.*;

import java.util.Optional;


@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @NonNull
    private String firstName; // Included in @RequiredArgsConstructor
    @NonNull
    private String lastName; // Not included in @RequiredArgsConstructor
    private String email = ""; // Not included in @RequiredArgsConstructor

//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
}
