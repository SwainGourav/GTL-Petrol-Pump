package com.petrol_pump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petrol_pump.entity.CustomerAttendee;

@Repository
public interface CustomerAttendeeRepository extends JpaRepository<CustomerAttendee, Long> {
}
