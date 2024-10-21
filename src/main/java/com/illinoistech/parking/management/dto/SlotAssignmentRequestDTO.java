package com.illinoistech.parking.management.dto;


import com.illinoistech.parking.management.entity.SlotAssignment;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SlotAssignmentRequestDTO {


    Integer assignment_id;
    Integer slot_id;
    Integer cust_id;
    String number_plate;
    Integer e_id;

    public static SlotAssignment toSlotAssignmentEntity(SlotAssignmentRequestDTO slotAssignmentRequestDTO) {
        return SlotAssignment.builder()
                .assignment_id(slotAssignmentRequestDTO.assignment_id)
                .slot_id(slotAssignmentRequestDTO.slot_id)
                .number_plate(slotAssignmentRequestDTO.number_plate)
                .cust_id(slotAssignmentRequestDTO.cust_id)
                .e_id(slotAssignmentRequestDTO.e_id).build();
    }

}
