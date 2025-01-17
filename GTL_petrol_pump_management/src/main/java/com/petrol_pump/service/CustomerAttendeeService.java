package com.petrol_pump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrol_pump.entity.CustomerAttendee;
import com.petrol_pump.repository.CustomerAttendeeRepository;

import java.util.List;

@Service
public class CustomerAttendeeService {

    @Autowired
    private CustomerAttendeeRepository repository;

    public List<CustomerAttendee> getAll() {
        return repository.findAll();
    }

    public CustomerAttendee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CustomerAttendee save(CustomerAttendee customerAttendee) {
        return repository.save(customerAttendee);
    }

    public CustomerAttendee update(Long id, CustomerAttendee customerAttendee) {
        CustomerAttendee existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(customerAttendee.getName());
            existing.setEmail(customerAttendee.getEmail());
            existing.setPhone(customerAttendee.getPhone());
            existing.setNozzleAssigned(customerAttendee.getNozzleAssigned());
            existing.setShiftActive(customerAttendee.isShiftActive());
            existing.setShiftStartTime(customerAttendee.getShiftStartTime());
            existing.setShiftEndTime(customerAttendee.getShiftEndTime());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
