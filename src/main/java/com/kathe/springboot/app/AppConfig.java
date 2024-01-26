package com.kathe.springboot.app;

import com.kathe.springboot.app.models.Item;
import com.kathe.springboot.app.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySources({
    @PropertySource(value="classpath:values.properties", encoding = "ISO8859-1"),
    @PropertySource(value="classpath:config.properties", encoding = "ISO8859-1"),
    @PropertySource(value="classpath:data.properties", encoding = "ISO8859-1"),
})
public class AppConfig {
    @Bean("defaultInvoice")
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara SONY", 1024D);
        Product p2 = new Product("Camara Samsung", 1500D);
        Product p3 = new Product("Celular Samsung", 2500D);

        return Arrays.asList(
                new Item(p1, 10),
                new Item(p2, 20),
                new Item(p3, 30)
        );
    }

    @Bean
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Silla Gamer", 1024D);
        Product p2 = new Product("Monitor Samsung", 1500D);
        Product p3 = new Product("Teclado Ergonómico", 2500D);

        return Arrays.asList(
                new Item(p1, 1),
                new Item(p2, 2),
                new Item(p3, 3)
        );
    }
}
