package com.kathe.springboot.app.interfaces;

import com.kathe.springboot.app.models.Product;

import java.util.List;

public interface ProductCommonInt {
    List<Product> findAll();
    Product findById(Long id);
}
