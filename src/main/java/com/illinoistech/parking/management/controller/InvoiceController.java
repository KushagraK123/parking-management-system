package com.illinoistech.parking.management.controller;

import com.illinoistech.parking.management.entity.Invoice;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @GetMapping
    List<Invoice> getAllInvoices() {
        return databaseAccessService.getAllInvoices();
    }

}
