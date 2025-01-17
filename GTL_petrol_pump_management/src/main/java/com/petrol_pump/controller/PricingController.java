package com.petrol_pump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petrol_pump.entity.Pricing;
import com.petrol_pump.service.PricingService;

import java.util.List;

@RestController
@RequestMapping("/pricings")
public class PricingController {

    @Autowired
    private PricingService service;

    @GetMapping
    public List<Pricing> getAllPricings() {
        return service.getAllPricings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pricing> getPricingById(@PathVariable Long id) {
        Pricing pricing = service.getPricingById(id);
        return pricing != null ? ResponseEntity.ok(pricing) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Pricing createPricing(@RequestBody Pricing pricing) {
        return service.savePricing(pricing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pricing> updatePricing(@PathVariable Long id, @RequestBody Pricing pricingDetails) {
        Pricing updatedPricing = service.updatePricing(id, pricingDetails);
        return updatedPricing != null ? ResponseEntity.ok(updatedPricing) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePricing(@PathVariable Long id) {
        service.deletePricing(id);
        return ResponseEntity.noContent().build();
    }
}
