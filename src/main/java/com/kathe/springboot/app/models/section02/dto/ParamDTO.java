package com.kathe.springboot.app.models.section02.dto;

import lombok.*;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
//@RequiredArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown=true)
public class ParamDTO {
    private String message = "undefined";
     @NonNull
    private Integer value ;
}
