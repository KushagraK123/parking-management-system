package com.illinoistech.parking.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "slot_assignment")
public class SlotAssignments {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer assignment_id;
    Integer slot_id;
    String number_plate;
    Integer e_id;
    Timestamp timeIssued;
}
