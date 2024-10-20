package com.illinoistech.parking.management.repository;

import com.illinoistech.parking.management.entity.VehicleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends CrudRepository<VehicleType, String> {
}
