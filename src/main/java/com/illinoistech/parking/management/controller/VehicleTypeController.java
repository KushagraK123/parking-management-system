package com.illinoistech.parking.management.controller;


import com.illinoistech.parking.management.entity.VehicleType;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/vehicleType")
public class VehicleTypeController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @PostMapping("/add")
    public VehicleType addVehicleType(VehicleType vehicleType) { return databaseAccessService.addNewVehicleType(vehicleType);}
    @GetMapping("/list")
    public List<VehicleType> getAllVehicleTypes() {
        return databaseAccessService.getAllVehicleTypes();
    }
}
