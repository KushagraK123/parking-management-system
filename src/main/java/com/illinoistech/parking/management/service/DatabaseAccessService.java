package com.illinoistech.parking.management.service;


import com.illinoistech.parking.management.entity.Customer;
import com.illinoistech.parking.management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseAccessService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach((customers::add));
        return customers;
    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
