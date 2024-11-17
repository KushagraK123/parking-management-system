package com.illinoistech.parking.management.repository;

import com.illinoistech.parking.management.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {

    @Query(value="SELECT sum(a.amount), b.vehicle_type \n" +
            "FROM \n" +
            "(parking_garage.invoice as a \n" +
            "LEFT JOIN parking_garage.vehicle as b\n" +
            "ON a.number_plate = b.number_plate) \n" +
            "GROUP BY\n" +
            "vehicle_type  ", nativeQuery=true)
    List<Object> getRevenueByVehicleType();

    @Query(value= """
            SELECT sum(a.amount) as sum, b.cust_name\s
                        FROM\s
                        (parking_garage.invoice as a\s
                        LEFT JOIN parking_garage.customer as b
                        ON a.cust_id = b.cust_id)\s
                        GROUP BY
                        b.cust_id \s
            """
            , nativeQuery=true)
    List<Object> getRevenueByCustomers();


    @Query(value= """
            SELECT avg(amount) as average_invoice_amount\s
                        FROM\s
                        parking_garage.invoice \s
            """
            , nativeQuery=true)
     Object getAverageInvoiceAmount();


    @Query(value= """
            SELECT number_plate, sum(amount)
            FROM invoice\s
            GROUP BY number_plate
            WITH ROLLUP
            """
            , nativeQuery=true)
    List<Object> getSumOfInvoicesByNumberPlate();

    @Query(value= """
            WITH invoices_sum_by_cust_id AS (
                SELECT\s
                    cust_id,
                    SUM(amount) AS total_spent
                FROM\s
                    invoice
              \s
                GROUP BY\s
                    cust_id
            )
                        
            SELECT\s
                i.total_spent,
                c.cust_name
            FROM\s
                invoices_sum_by_cust_id i
            JOIN\s
                customer c ON i.cust_id = c.cust_id
                        
            WHERE i.total_spent > ?1
                        
            ORDER BY\s
                i.total_spent DESC;
            """
            , nativeQuery=true)
    List<Object> getAllCustomersWhoseInvoicesSumIsMoreThanAmount(int amount);





}
