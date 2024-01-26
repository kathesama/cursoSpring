package com.kathe.springboot.app.controllers;

import com.kathe.springboot.app.interfaces.ProductRepositoryInt;
import com.kathe.springboot.app.models.Product;
import com.kathe.springboot.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    // Se importa la interface para desacoplar el servicio, lo hace más transparente
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> products() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product productById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
