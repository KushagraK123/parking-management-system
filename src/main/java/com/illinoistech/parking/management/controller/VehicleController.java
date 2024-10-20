package com.illinoistech.parking.management.controller;


import com.illinoistech.parking.management.entity.Vehicle;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController()
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @PostMapping("/add")
    public Vehicle addVehicle(Vehicle vehicle) { return databaseAccessService.addNewVehicle(vehicle);}
    @GetMapping("/list")
    public List<Vehicle> getAllVehicleTypes() {
        return databaseAccessService.getAllVehicles();
    }
}

