package com.illinoistech.parking.management.service;


import com.illinoistech.parking.management.entity.*;
import com.illinoistech.parking.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseAccessService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    VehicleOwnershipRepository vehicleOwnershipRepository;

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SlotAssignmentRepository slotAssignmentRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach((customers::add));
        return customers;
    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach((employees::add));
        return employees;
    }

    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<ParkingSpot> getAllParkingSpots() {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpotRepository.findAll().forEach((parkingSpots::add));
        return parkingSpots;
    }
    public ParkingSpot addNewParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }
    public List<ParkingSpot> getAvailableParkingSpots() {
        return parkingSpotRepository.findAvailableParkingSpots();
    }
    public List<ParkingSpot> getUsedParkingSpots() {
        return parkingSpotRepository.findUsedParkingSpots();
    }


    public List<VehicleOwnership> getAllVehicleOwnerShip() {
        List<VehicleOwnership> vehicleOwnerships = new ArrayList<>();
        vehicleOwnershipRepository.findAll().forEach((vehicleOwnerships::add));
        return vehicleOwnerships;
    }

    public List<VehicleOwnership> findVehicleOwnershipByCustId(Integer cust_id) {
        return vehicleOwnershipRepository.findByCustId(cust_id);
    }


    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicleRepository.findAll().forEach((vehicles::add));
        return vehicles;
    }

    public Vehicle addNewVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<VehicleType> getAllVehicleTypes() {
        List<VehicleType> vehicles = new ArrayList<>();
        vehicleTypeRepository.findAll().forEach((vehicles::add));
        return vehicles;
    }

    public VehicleType addNewVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public List<SlotAssignment> getAllSlotAssignments() {
        List<SlotAssignment> slotAssignments = new ArrayList<>();
        slotAssignmentRepository.findAll().forEach((slotAssignments::add));
        return slotAssignments;
    }
    public SlotAssignment assignSlot(SlotAssignment slotAssignment) {
        return slotAssignmentRepository.save(slotAssignment);
    }

    public void releaseSpot(Integer slotAssignmentId) throws Exception {
        if(slotAssignmentRepository.existsById(slotAssignmentId)) {
            slotAssignmentRepository.deleteById(slotAssignmentId);
        } else {
            throw new Exception("Slot Not Assigned");
        }
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceRepository.findAll().forEach((invoices::add));
        return invoices;
    }

}
