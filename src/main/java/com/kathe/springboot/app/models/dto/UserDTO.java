package com.kathe.springboot.app.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kathe.springboot.app.models.User;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserDTO{
//    @Setter(AccessLevel.NONE)
//    private Long id;

    @Delegate
    @JsonIgnore
    private User user;

    private String title = "";
}
