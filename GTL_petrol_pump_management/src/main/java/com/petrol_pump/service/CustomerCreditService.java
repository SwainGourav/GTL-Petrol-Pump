package com.petrol_pump.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.petrol_pump.entity.CustomerCredit;
import com.petrol_pump.repository.CustomerCreditRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerCreditService {

    private final CustomerCreditRepository repository;

    public List<CustomerCredit> getAllCustomerCredits() {
        return repository.findAll();
    }

    public Optional<CustomerCredit> getCustomerCreditById(Long id) {
        return repository.findById(id);
    }

    public CustomerCredit createCustomerCredit(CustomerCredit customerCredit) {
        return repository.save(customerCredit);
    }

    public CustomerCredit updateCustomerCredit(Long id, CustomerCredit customerCreditDetails) {
        return repository.findById(id).map(customerCredit -> {
            customerCredit.setName(customerCreditDetails.getName());
            customerCredit.setBalanceAmt(customerCreditDetails.getBalanceAmt());
            customerCredit.setPaidAmt(customerCreditDetails.getPaidAmt());
            customerCredit.setEmail(customerCreditDetails.getEmail());
            customerCredit.setTransactionDatetime(customerCreditDetails.getTransactionDatetime());
            customerCredit.setMoNo(customerCreditDetails.getMoNo());
            customerCredit.setMonoAddress(customerCreditDetails.getMonoAddress());
            customerCredit.setVersion(customerCreditDetails.getVersion());
            return repository.save(customerCredit);
        }).orElseThrow(() -> new RuntimeException("CustomerCredit not found with id: " + id));
    }

    public void deleteCustomerCredit(Long id) {
        repository.deleteById(id);
    }
}
