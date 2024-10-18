package com.illinoistech.parking.management.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ownership")
public class VehicleOwnership {
    Integer cust_id;
    String number_plate;
}
