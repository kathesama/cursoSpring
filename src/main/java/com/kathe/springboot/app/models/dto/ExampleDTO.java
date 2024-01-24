package com.kathe.springboot.app.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown=true)
public class ExampleDTO {
    private String title = "";
    private String firstName;
    private String lastName;
}
