package com.kathe.springboot.app.repositories.section03;

import com.kathe.springboot.app.interfaces.section03.ProductRepositoryInt;
import com.kathe.springboot.app.models.section03.ProductC3;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryFooImpl implements ProductRepositoryInt {
    @Override
    public List<ProductC3> findAll() {
        return Collections.singletonList(new ProductC3(6L, "foo 6", 1000D));
    }

    @Override
    public ProductC3 findById(Long id) {
        return new ProductC3(6L, "foo 6", 1000D);
    }
}
