package com.petrol_pump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrol_pump.entity.Machine;
import com.petrol_pump.repository.MachineRepository;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineRepository repository;

    public List<Machine> getAllMachines() {
        return repository.findAll();
    }

    public Machine getMachineById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Machine saveMachine(Machine machine) {
        return repository.save(machine);
    }

    public Machine updateMachine(Long id, Machine machineDetails) {
        Machine machine = repository.findById(id).orElse(null);
        if (machine != null) {
            machine.setName(machineDetails.getName());
            machine.setMachineType(machineDetails.getMachineType());
            return repository.save(machine);
        }
        return null;
    }

    public void deleteMachine(Long id) {
        repository.deleteById(id);
    }
}
