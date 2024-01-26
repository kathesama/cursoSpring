package com.kathe.springboot.app.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(force = true)
@JsonIgnoreProperties(ignoreUnknown=true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Product implements Cloneable{
    @NonNull
    private Long id;

    private String name = "undefined";
    private Double price = 0.0;

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(this.getId(), this.getName(), this.getPrice());
        }
    }
}
