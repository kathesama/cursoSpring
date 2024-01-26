package com.kathe.springboot.app.repositories;

import com.kathe.springboot.app.interfaces.ProductRepositoryInt;
import com.kathe.springboot.app.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryFooImpl implements ProductRepositoryInt {
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(6L, "foo 6", 1000D));
    }

    @Override
    public Product findById(Long id) {
        return new Product(6L, "foo 6", 1000D);
    }
}
