package com.petrol_pump.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer_credit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double balanceAmt;

    private Double paidAmt;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private java.time.LocalDateTime transactionDatetime;

    private String moNo;

    private String monoAddress;

    private Long version;
}

