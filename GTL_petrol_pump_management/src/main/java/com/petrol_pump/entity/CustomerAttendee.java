package com.petrol_pump.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "customer_attendees")
@Getter
@Setter
public class CustomerAttendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    private String nozzleAssigned;

    @Column(nullable = false)
    private boolean shiftActive;

    private String shiftStartTime;
    private String shiftEndTime;
}
