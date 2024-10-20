package com.illinoistech.parking.management.controller;


import com.illinoistech.parking.management.entity.SlotAssignment;
import com.illinoistech.parking.management.dto.SlotAssignmentRequestDTO;
import com.illinoistech.parking.management.service.DatabaseAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static com.illinoistech.parking.management.dto.SlotAssignmentRequestDTO.toSlotAssignmentEntity;

@RestController()
@RequestMapping("/slotAssignment")
public class SlotAssignmentController {

    @Autowired
    DatabaseAccessService databaseAccessService;

    @PostMapping("/assign")
    public SlotAssignment assignSlot(SlotAssignmentRequestDTO slotAssignmentRequestDTO) {
        return databaseAccessService.assignSlot(toSlotAssignmentEntity(slotAssignmentRequestDTO));
    }

    @PostMapping("/release")
    public String releaseSpot(Integer slotAssignmentId) {
        try {
            databaseAccessService.releaseSpot(slotAssignmentId);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Slot Release successfully";
    }

    @GetMapping("/listAll")
    public List<SlotAssignment> getAllAssignedSlots() {
        return databaseAccessService.getAllSlotAssignments();
    }

}
