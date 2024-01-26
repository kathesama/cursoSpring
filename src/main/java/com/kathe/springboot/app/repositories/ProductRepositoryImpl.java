package com.kathe.springboot.app.repositories;

import com.kathe.springboot.app.interfaces.ProductRepositoryInt;
import com.kathe.springboot.app.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepositoryInt {
    List<Product> data;
    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    public ProductRepositoryImpl(){
        logger.info("Repository called here -----------------------------------------------------------------");
        this.data = Arrays.asList(
                Product.builder().id(1L).name("pr 1").price(100D).build(),
                new Product(2L, "pr 2", 200D),
                new Product(3L, "pr 3", 300D),
                new Product(4L, "pr 4", 400D)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }
}
