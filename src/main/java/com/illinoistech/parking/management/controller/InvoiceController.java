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

    @GetMapping("/revenueByVehicle")
    List<Object> getRevenueByVehicleType() {
        return databaseAccessService.getRevenueByVehicleType();
    }

    @GetMapping("/revenueByCustomer")
    Object getRevenueByCustomer() {
        return databaseAccessService.getRevenueByCustomers();
    }

    @GetMapping("/averageInvoiceAmount")
    Object getAverageInvoiceAmount() {
        return databaseAccessService.getAverageInvoiceAmount();
    }

    @GetMapping("/sumOfInvoiceByNumberPlate")
    List<Object> getSumOfInvoicesByNumberPlate() {
        return databaseAccessService.getSumOfInvoicesByNumberPlate();
    }

    @GetMapping("/getAllCustomersWhoseInvoicesSumIsMoreThanAmount")
    List<Object> getAllCustomersWhoseInvoicesSumIsMoreThanAmount(Integer amount) {
        return databaseAccessService.getAllCustomersWhoseInvoicesSumIsMoreThanAmount(amount);
    }



}
