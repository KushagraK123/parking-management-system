package com.illinoistech.parking.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "slot_assignment")
public class SlotAssignment {
    @Id
    Integer assignment_id;
    Integer cust_id;
    Integer slot_id;
    String number_plate;
    Integer e_id;
    Timestamp timeIssued;
}
