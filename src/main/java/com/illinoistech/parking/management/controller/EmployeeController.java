package com.illinoistech.parking.management.controller;

import com.illinoistech.parking.management.entity.Employee;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    DatabaseAccessService databaseAccessService;

    @PostMapping("/add")
    public Employee addEmployee(Employee employee) throws Exception{ return databaseAccessService.addNewEmployee(employee);}
    @PutMapping("/update")
    public Employee updateEmployee(Employee employee) throws Exception{ return databaseAccessService.updateEmployee(employee);}
    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return databaseAccessService.getAllEmployees();
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(Integer e_id) {
        databaseAccessService.deleteEmployee(e_id);
    }
}
