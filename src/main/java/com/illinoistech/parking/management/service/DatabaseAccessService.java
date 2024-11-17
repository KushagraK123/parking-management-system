package com.illinoistech.parking.management.service;


import com.illinoistech.parking.management.entity.*;
import com.illinoistech.parking.management.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
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

    public Customer addNewCustomer(Customer customer) throws Exception {
        if(!customerRepository.existsById(customer.getCust_id())) {
            return customerRepository.save(customer);
        }else {
            throw new Exception("The Customer already exists");
        }

    }

    public Customer updateCustomer(Customer customer) throws Exception {
        if(customerRepository.existsById(customer.getCust_id())) {
            return customerRepository.save(customer);
        }else {
            throw new Exception("The Customer does not exist");
        }

    }

    public void deleteCustomer(Integer cust_id) {
        customerRepository.deleteById(cust_id);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach((employees::add));
        return employees;
    }

    public Employee addNewEmployee(Employee employee) throws Exception {
        if(!employeeRepository.existsById(employee.getE_id())) {
            return employeeRepository.save(employee);
        } else {
            throw new Exception("Employee already exists");
        }
    }

    public Employee updateEmployee(Employee employee) throws Exception {
        if(employeeRepository.existsById(employee.getE_id())) {
            return employeeRepository.save(employee);
        } else {
            throw new Exception("Employee does not exist");
        }
    }

    public void deleteEmployee(Integer e_id) {
        employeeRepository.deleteById(e_id);
    }

    public List<ParkingSpot> getAllParkingSpots() {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpotRepository.findAll().forEach((parkingSpots::add));
        return parkingSpots;
    }

    public void deleteParkingSpot(Integer spot_id) {
        parkingSpotRepository.deleteById(spot_id);
    }
    public ParkingSpot addNewParkingSpot(ParkingSpot parkingSpot) throws Exception{
        if(!parkingSpotRepository.existsById(parkingSpot.getSlot_id())) {
            return parkingSpotRepository.save(parkingSpot);
        } else {
            throw new Exception("The parking slot with given id already exists");
        }
    }

    public ParkingSpot updateParkingSpot(ParkingSpot parkingSpot) throws Exception{
        if(parkingSpotRepository.existsById(parkingSpot.getSlot_id())) {
            return parkingSpotRepository.save(parkingSpot);
        } else {
            throw new Exception("The parking slot with given id does not exist");
        }
    }

    public List<Object> getAvailableParkingSpots() {
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

    public Vehicle addNewVehicle(Vehicle vehicle) throws Exception {
        if(!vehicleRepository.existsById(vehicle.getNumber_plate())) {
            return vehicleRepository.save(vehicle);
        }
        else {
            throw new Exception("Vehicle already exists");
        }
    }

    public Vehicle updateVehicle(Vehicle vehicle) throws Exception {
        if(vehicleRepository.existsById(vehicle.getNumber_plate())) {
            return vehicleRepository.save(vehicle);
        }
        else {
            throw new Exception("Vehicle does not exist");
        }
    }


    public List<VehicleType> getAllVehicleTypes() {
        List<VehicleType> vehicles = new ArrayList<>();
        vehicleTypeRepository.findAll().forEach((vehicles::add));
        return vehicles;
    }

    public VehicleType addNewVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }
    public void deleteVehicle(String number_plate) {
        vehicleRepository.deleteById(number_plate);
    }
    public List<SlotAssignment> getAllSlotAssignments() {
        List<SlotAssignment> slotAssignments = new ArrayList<>();
        slotAssignmentRepository.findAll().forEach((slotAssignments::add));
        return slotAssignments;
    }
    public SlotAssignment assignSlot(SlotAssignment slotAssignment) {
        return slotAssignmentRepository.save(slotAssignment);
    }

    @Transactional
    public void releaseSpot(Integer slotAssignmentId) throws Exception {
        if(slotAssignmentRepository.findById(slotAssignmentId).isPresent()) {
            SlotAssignment slotAssignment = slotAssignmentRepository.findById(slotAssignmentId).get();
            Vehicle vehicle = vehicleRepository.findById(slotAssignment.getNumber_plate()).orElseThrow();
            VehicleType vehicleType = vehicleTypeRepository.findById(vehicle.getVehicleType()).orElseThrow();
            Invoice currInvoice =  Invoice.builder()
                    .cust_id(slotAssignment.getCust_id())
                    .amount(calculateBillingAmount(slotAssignment.getTimeIssued(),
                            vehicleType.getHourly_rate()))
                    .number_plate(slotAssignment.getNumber_plate())
                    .timestamp(Timestamp.from(Instant.now()))
                    .build();
            invoiceRepository.save(currInvoice);
            slotAssignmentRepository.deleteById(slotAssignmentId);
        } else {
            throw new Exception("Slot Not Assigned");
        }
    }

    private Double calculateBillingAmount(Timestamp timeIssued, Double hourly_rate) {
        int hours = getHours(timeIssued);
        return hourly_rate*(double)hours;
    }

    private int getHours(Timestamp timeIssued) {
        Timestamp currTime = Timestamp.from(Instant.now());
        long millis = currTime.getTime() - timeIssued.getTime();
        double divisor = 1000 * 60 * 60;
        return (int) Math.ceil((double)millis/ divisor);
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceRepository.findAll().forEach((invoices::add));
        return invoices;
    }

    public List<Object> getRevenueByVehicleType() {
        return invoiceRepository.getRevenueByVehicleType();
    }

    public List<Object> getRevenueByCustomers() {
        return invoiceRepository.getRevenueByCustomers();
    }

    public Object getAverageInvoiceAmount() {
        return invoiceRepository.getAverageInvoiceAmount();
    }

    public List<Object> getSumOfInvoicesByNumberPlate() { return invoiceRepository.getSumOfInvoicesByNumberPlate(); }

    public  List<Object> getAllCustomersWhoseInvoicesSumIsMoreThanAmount(int amount) {
        return invoiceRepository.getAllCustomersWhoseInvoicesSumIsMoreThanAmount(amount);
    }

}
