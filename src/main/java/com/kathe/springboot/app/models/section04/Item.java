package com.kathe.springboot.app.models.section04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Item {
    private Product product;
    private Integer quantity;

    public Double getImportQuantity (){
      return quantity * product.getPrice();
    }
}
