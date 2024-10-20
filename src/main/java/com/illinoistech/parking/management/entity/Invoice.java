package com.illinoistech.parking.management.entity;


import jakarta.persistence.Entity;
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
@Entity(name = "invoice")
public class Invoice {

    @Id
    Integer invoice_id;
    Integer cust_id;
    String number_plate;
    Timestamp timestamp;
    Double amount;
}
