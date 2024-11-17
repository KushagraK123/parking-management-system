package com.illinoistech.parking.management.controller;


import com.illinoistech.parking.management.entity.ParkingSpot;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @PostMapping("/add")
    public ParkingSpot addParkingspot(ParkingSpot parkingSpot) throws Exception { return databaseAccessService.addNewParkingSpot(parkingSpot);}

    @PutMapping("/update")
    public ParkingSpot updateParkingspot(ParkingSpot parkingSpot) throws Exception { return databaseAccessService.updateParkingSpot(parkingSpot);}

    @GetMapping("/list")
    public List<ParkingSpot> getAllParkingSpots() {
        return databaseAccessService.getAllParkingSpots();
    }

    @GetMapping("/availableSpots")
    public List<Object> getAllAvailableParkingSpots() {
        return databaseAccessService.getAvailableParkingSpots();
    }

    @GetMapping("/usedSpots")
    public List<ParkingSpot> getAllUsedParkingSpots() {
        return databaseAccessService.getUsedParkingSpots();
    }

    @DeleteMapping("/delete")
    public void deleteParkingSpot(Integer spot_id) {
        databaseAccessService.deleteParkingSpot(spot_id);
    }
}
