package com.petrol_pump.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petrol_pump.entity.CustomerCredit;
import com.petrol_pump.service.CustomerCreditService;

import java.util.List;

@RestController
@RequestMapping("/customer-credits")
@RequiredArgsConstructor
public class CustomerCreditController {
	@Autowired
    private  CustomerCreditService service;

    @GetMapping
    public ResponseEntity<List<CustomerCredit>> getAllCustomerCredits() {
        return ResponseEntity.ok(service.getAllCustomerCredits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerCredit> getCustomerCreditById(@PathVariable Long id) {
        return service.getCustomerCreditById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerCredit> createCustomerCredit(@RequestBody CustomerCredit customerCredit) {
        return new ResponseEntity<>(service.createCustomerCredit(customerCredit), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerCredit> updateCustomerCredit(@PathVariable Long id, @RequestBody CustomerCredit customerCredit) {
        try {
            return ResponseEntity.ok(service.updateCustomerCredit(id, customerCredit));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerCredit(@PathVariable Long id) {
        service.deleteCustomerCredit(id);
        return ResponseEntity.noContent().build();
    }
}
