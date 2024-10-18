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
@Entity(name = "vehicle_type")
public class VehicleType {
    @Id
    String vehicle_type;
    Double hourly_rate;
    Integer vehicle_capacity;
}
