package com.kathe.springboot.app.controllers.section04;

import com.kathe.springboot.app.models.section04.Invoice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/invoices")
public class InvoiceController {

    private final Invoice invoice;
    public InvoiceController(Invoice invoice) {
        this.invoice = invoice;
    }

    @GetMapping
    Invoice invoices() {
        return invoice;
    }
}
