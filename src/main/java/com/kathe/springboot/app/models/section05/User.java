package com.kathe.springboot.app.models.section05;

import lombok.*;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;

    private Role role = null;
}
