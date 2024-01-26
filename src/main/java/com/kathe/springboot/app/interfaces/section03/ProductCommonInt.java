package com.kathe.springboot.app.interfaces.section03;

import com.kathe.springboot.app.models.section03.ProductC3;

import java.util.List;

public interface ProductCommonInt {
    List<ProductC3> findAll();
    ProductC3 findById(Long id);
}
