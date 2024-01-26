package com.kathe.springboot.app.models.section03;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(force = true)
@JsonIgnoreProperties(ignoreUnknown=true)
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductC3 implements Cloneable{
    @NonNull
    private Long id;

    private String name = "undefined";
    private Double price = 0.0;

    @Override
    public ProductC3 clone() {
        try {
            return (ProductC3) super.clone();
        } catch (CloneNotSupportedException e) {
            return new ProductC3(this.getId(), this.getName(), this.getPrice());
        }
    }
}
