package com.illinoistech.parking.management.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "invoice")
public class Invoice {


    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer invoice_id;
    Integer cust_id;
    String number_plate;
    Timestamp timestamp;
    Double amount;
}
