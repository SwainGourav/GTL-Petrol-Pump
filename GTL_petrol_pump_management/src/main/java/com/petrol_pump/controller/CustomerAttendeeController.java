package com.petrol_pump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petrol_pump.entity.CustomerAttendee;
import com.petrol_pump.service.CustomerAttendeeService;

import java.util.List;

@RestController
@RequestMapping("/customer-attendees")
public class CustomerAttendeeController {

    @Autowired
    private CustomerAttendeeService service;

    @GetMapping
    public List<CustomerAttendee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAttendee> getById(@PathVariable Long id) {
        CustomerAttendee customerAttendee = service.getById(id);
        return customerAttendee != null ? ResponseEntity.ok(customerAttendee) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CustomerAttendee create(@RequestBody CustomerAttendee customerAttendee) {
        return service.save(customerAttendee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerAttendee> update(@PathVariable Long id, @RequestBody CustomerAttendee customerAttendee) {
        CustomerAttendee updated = service.update(id, customerAttendee);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
