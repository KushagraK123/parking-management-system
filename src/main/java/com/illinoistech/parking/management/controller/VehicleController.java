package com.illinoistech.parking.management.controller;


import com.illinoistech.parking.management.entity.Vehicle;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @PostMapping("/add")
    public Vehicle addVehicle(Vehicle vehicle) throws Exception{ return databaseAccessService.addNewVehicle(vehicle);}

    @PutMapping("/update")
    public Vehicle updateVehicle(Vehicle vehicle) throws Exception{ return databaseAccessService.updateVehicle(vehicle);}
    @GetMapping("/list")
    public List<Vehicle> getAllVehicleTypes() {
        return databaseAccessService.getAllVehicles();
    }

    @DeleteMapping("/delete")
    public void deleteVehicle(String number_plate) {
        databaseAccessService.deleteVehicle(number_plate);
    }
}

