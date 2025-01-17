package com.petrol_pump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petrol_pump.entity.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
}
