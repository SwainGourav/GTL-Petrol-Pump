package com.petrol_pump.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petrol_pump.entity.CustomerCredit;

@Repository
public interface CustomerCreditRepository extends JpaRepository<CustomerCredit, Long> {
}
