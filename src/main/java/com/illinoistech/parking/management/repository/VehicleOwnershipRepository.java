package com.illinoistech.parking.management.repository;

import com.illinoistech.parking.management.entity.VehicleOwnership;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleOwnershipRepository extends CrudRepository<VehicleOwnership, Integer> {
    @Query(value = "SELECT * FROM ownership where cust_id = ?1", nativeQuery = true)
    List<VehicleOwnership> findByCustId(Integer cust_id);
}
