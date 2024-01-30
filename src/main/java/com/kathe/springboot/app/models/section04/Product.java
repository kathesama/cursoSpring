package com.kathe.springboot.app.models.section04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Product {
    private String name;
    private Double price;
}
