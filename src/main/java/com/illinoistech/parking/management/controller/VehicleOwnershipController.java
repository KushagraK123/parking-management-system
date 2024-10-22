package com.illinoistech.parking.management.controller;

import com.illinoistech.parking.management.entity.VehicleOwnership;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/vehicleOwnership")
public class VehicleOwnershipController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @GetMapping("/list")
    public List<VehicleOwnership> getAllOwnerships() { return databaseAccessService.getAllVehicleOwnerShip();}
    @GetMapping("/getVehiclesByCustomer")
    public List<VehicleOwnership> getVehicleOwnershipByCustomerId(Integer cust_id) {
        return databaseAccessService.findVehicleOwnershipByCustId(cust_id);
    }


}
