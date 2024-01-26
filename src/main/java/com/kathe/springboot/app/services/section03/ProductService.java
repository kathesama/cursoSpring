package com.kathe.springboot.app.services.section03;

import com.kathe.springboot.app.interfaces.section03.ProductRepositoryInt;
import com.kathe.springboot.app.interfaces.section03.ProductServiceInt;
import com.kathe.springboot.app.models.section03.ProductC3;
import com.kathe.springboot.app.repositories.section03.ProductRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

/*
La inyección a través del constructor es una práctica común en Spring y otros frameworks de inyección de dependencias.
Aunque puede parecer un poco extraño al principio si estás acostumbrado a la inyección de campo, tiene varias ventajas:
.- Inmutabilidad: Los campos inyectados a través del constructor pueden ser finales, lo que significa que una vez que se
    asignan, no pueden ser cambiados. Esto puede ayudar a prevenir errores.
.- Facilita las pruebas: Cuando inyectas dependencias a través del constructor, es fácil proporcionar tus propias
    implementaciones o mocks de esas dependencias cuando estás probando.
.- Evita el estado parcialmente inicializado: Con la inyección de campo, existe el riesgo de que se utilice un objeto
    antes de que todas sus dependencias hayan sido inyectadas. Con la inyección a través del constructor, esto no puede
    suceder.

Promueve el diseño de código limpio: La inyección a través del constructor te obliga a ser consciente de cuántas
dependencias tiene tu clase. Si una clase tiene demasiados parámetros en su constructor, puede ser una señal de que la
clase está haciendo demasiado y debería ser dividida.
*/
@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInt {
//    ProductRepositoryImpl repository = new ProductRepositoryImpl();
//    private final ProductRepositoryImpl repository;
//    @Autowired
    private final ProductRepositoryInt repository;
    private final Environment environment;

    // se puede reemplazar por @RequiredArgsConstructor
//    @Autowired
//    public ProductService(ProductRepositoryInt repository) {
//        this.repository = repository;
//    }

    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    @Override
    public List<ProductC3> findAll() {
        logger.info("Service called here -----------------------------------------------------------------");
        Double taxValue = environment.getProperty("config.price.tax", Double.class);
        logger.info(String.valueOf(taxValue));
        return repository.findAll().stream().map(product -> {
//            ProductC3 productC3Temp = new ProductC3(product.getId(), product.getName(), product.getPrice());
            ProductC3 productC3Temp = product.clone();
            productC3Temp.setPrice(productC3Temp.getPrice() * taxValue);

            return productC3Temp;
        }).toList();
    }

    @Override
    public ProductC3 findById(Long id) {
        return repository.findById(id);
    }
}
