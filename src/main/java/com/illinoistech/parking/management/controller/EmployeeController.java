package com.illinoistech.parking.management.controller;

import com.illinoistech.parking.management.entity.Employee;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    DatabaseAccessService databaseAccessService;

    @PostMapping("/add")
    public Employee addEmployee(Employee employee) { return databaseAccessService.addNewEmployee(employee);}
    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return databaseAccessService.getAllEmployees();
    }
}
