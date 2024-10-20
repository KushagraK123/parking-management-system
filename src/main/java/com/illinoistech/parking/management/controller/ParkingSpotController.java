package com.illinoistech.parking.management.controller;


import com.illinoistech.parking.management.entity.ParkingSpot;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @PostMapping("/add")
    public ParkingSpot addParkingspot(ParkingSpot parkingSpot) { return databaseAccessService.addNewParkingSpot(parkingSpot);}
    @GetMapping("/list")
    public List<ParkingSpot> getAllParkingSpots() {
        return databaseAccessService.getAllParkingSpots();
    }

    @GetMapping("/availableSpots")
    public List<ParkingSpot> getAllAvailableParkingSpots() {
        return databaseAccessService.getAvailableParkingSpots();
    }

    @GetMapping("/usedSpots")
    public List<ParkingSpot> getAllUsedParkingSpots() {
        return databaseAccessService.getUsedParkingSpots();
    }
}
