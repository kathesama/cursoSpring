package com.kathe.springboot.app.repositories.section03;

import com.kathe.springboot.app.interfaces.section03.ProductRepositoryInt;
import com.kathe.springboot.app.models.section03.ProductC3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepositoryInt {
    List<ProductC3> data;
    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    public ProductRepositoryImpl(){
        logger.info("Repository called here -----------------------------------------------------------------");
        this.data = Arrays.asList(
                ProductC3.builder().id(1L).name("pr 1").price(100D).build(),
                new ProductC3(2L, "pr 2", 200D),
                new ProductC3(3L, "pr 3", 300D),
                new ProductC3(4L, "pr 4", 400D)
        );
    }

    @Override
    public List<ProductC3> findAll() {
        return data;
    }

    @Override
    public ProductC3 findById(Long id) {
        return data.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }
}
