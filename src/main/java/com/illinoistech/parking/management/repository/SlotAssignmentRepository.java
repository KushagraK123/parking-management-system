package com.illinoistech.parking.management.repository;


import com.illinoistech.parking.management.entity.SlotAssignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotAssignmentRepository extends CrudRepository<SlotAssignment, Integer> {

}
