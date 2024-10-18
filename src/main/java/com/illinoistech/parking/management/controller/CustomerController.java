package com.illinoistech.parking.management.controller;

import com.illinoistech.parking.management.entity.Customer;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("")
public class CustomerController {

    @Autowired
    DatabaseAccessService databaseAccessService;


    @PostMapping("/customer")
    public Customer addCustomer(Customer customer) { return databaseAccessService.addNewCustomer(customer);}
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return databaseAccessService.getAllCustomers();
    }

}
