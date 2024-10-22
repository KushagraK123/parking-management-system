package com.illinoistech.parking.management.controller;

import com.illinoistech.parking.management.entity.Customer;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @DeleteMapping("/delete")
    public void deleteCustomer(Integer cust_id) { databaseAccessService.deleteCustomer(cust_id);}

    @PostMapping("/add")
    public Customer addCustomer(Customer customer) throws Exception { return databaseAccessService.addNewCustomer(customer);}

    @PutMapping("/update")
    public Customer updateCustomer(Customer customer) throws Exception { return databaseAccessService.updateCustomer(customer);}

    @GetMapping("/list")
    public List<Customer> getAllCustomers() {
        return databaseAccessService.getAllCustomers();
    }



}
