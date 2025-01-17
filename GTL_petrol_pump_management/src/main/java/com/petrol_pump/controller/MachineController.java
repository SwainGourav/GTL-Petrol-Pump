package com.petrol_pump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petrol_pump.entity.Machine;
import com.petrol_pump.service.MachineService;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    @Autowired
    private MachineService service;

    @GetMapping
    public List<Machine> getAllMachines() {
        return service.getAllMachines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        Machine machine = service.getMachineById(id);
        return machine != null ? ResponseEntity.ok(machine) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        return service.saveMachine(machine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(@PathVariable Long id, @RequestBody Machine machineDetails) {
        Machine updatedMachine = service.updateMachine(id, machineDetails);
        return updatedMachine != null ? ResponseEntity.ok(updatedMachine) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        service.deleteMachine(id);
        return ResponseEntity.noContent().build();
    }
}
