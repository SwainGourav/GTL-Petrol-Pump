package com.petrol_pump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrol_pump.entity.Pricing;
import com.petrol_pump.repository.PricingRepository;

import java.util.List;

@Service
public class PricingService {

    @Autowired
    private PricingRepository repository;

    public List<Pricing> getAllPricings() {
        return repository.findAll();
    }

    public Pricing getPricingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pricing savePricing(Pricing pricing) {
        return repository.save(pricing);
    }

    public Pricing updatePricing(Long id, Pricing pricingDetails) {
        Pricing pricing = repository.findById(id).orElse(null);
        if (pricing != null) {
            pricing.setPricePerLiter(pricingDetails.getPricePerLiter());
            pricing.setCreatedBy(pricingDetails.getCreatedBy());
            pricing.setFuelType(pricingDetails.getFuelType());
            pricing.setDescription(pricingDetails.getDescription());
            return repository.save(pricing);
        }
        return null;
    }

    public void deletePricing(Long id) {
        repository.deleteById(id);
    }
}
