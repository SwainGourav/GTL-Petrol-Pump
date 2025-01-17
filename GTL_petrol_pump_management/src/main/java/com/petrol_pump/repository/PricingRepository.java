package com.petrol_pump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petrol_pump.entity.Pricing;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long> {
}
