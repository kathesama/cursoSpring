package com.kathe.springboot.app.models.section04;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class Invoice {
    private static final Logger logger = LoggerFactory.getLogger(Invoice.class);
//    @Autowired
    private final Client client;
    private final List<Item> itemsInvoice;

    @Value("${invoice.description}")
    private String description = null;

    @PostConstruct
    public void init(){
        logger.info("////////////////////////////// Creando el componente de la factura");
        client.setName(client.getName() + " Estefania");
    }

    @PreDestroy
    public void destroy() {
        logger.info("////////////////////////////// Destruyendo el componente de la factura");
    }

    @Autowired
    public Invoice(Client client, @Qualifier("defaultInvoice") List<Item> itemsInvoice){
        this.client = client;
        this.itemsInvoice = itemsInvoice;
    }

    public Double getTotal() {
        return itemsInvoice.stream()
                .map(item -> item.getImportQuantity())
                .reduce(0.0, (sum, importe) -> sum + importe);
    }
}
