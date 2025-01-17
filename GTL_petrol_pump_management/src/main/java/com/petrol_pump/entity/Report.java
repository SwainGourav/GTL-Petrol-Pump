package com.petrol_pump.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "reports")
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "total_petrol_dispensed", columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")
    private Double totalPetrolDispensed = 0.00;

    @Column(name = "total_sales", columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")
    private Double totalSales = 0.00;

    @Column(name = "petrol_used_for_testing", columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")
    private Double petrolUsedForTesting = 0.00;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdAt;

    @Column(name = "total_amount_earned", nullable = false)
    private Double totalAmountEarned;

    @Column(name = "total_fuel_consumed_for_testing", nullable = false)
    private Double totalFuelConsumedForTesting;

    @Column(name = "total_fuel_dispensed", nullable = false)
    private Double totalFuelDispensed;
}
