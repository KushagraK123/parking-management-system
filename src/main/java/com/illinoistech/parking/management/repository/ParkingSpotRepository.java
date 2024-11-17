package com.illinoistech.parking.management.repository;

import com.illinoistech.parking.management.entity.ParkingSpot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ParkingSpotRepository extends CrudRepository<ParkingSpot, Integer> {

    @Query(value = "SELECT * FROM parking_spot WHERE slot_id IN (SELECT slot_id FROM slot_assignment)", nativeQuery = true)
    List<ParkingSpot> findUsedParkingSpots();

    @Query(value = """
            SELECT slot_id FROM parking_garage.parking_spot EXCEPT\s
            SELECT slot_id FROM parking_garage.slot_assignment
            """, nativeQuery = true)
    List<Object> findAvailableParkingSpots();
}