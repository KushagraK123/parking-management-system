package com.illinoistech.parking.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "parking_spot")
public class ParkingSpot {
    @Id
    Integer slot_id;
    Integer vehicle_capacity;
    Integer floor;
}
