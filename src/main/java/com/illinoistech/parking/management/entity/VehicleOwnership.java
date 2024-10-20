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
@Entity(name = "ownership")
public class VehicleOwnership {
    @Id
    Integer ownership_id;
    Integer cust_id;
    String number_plate;
}
