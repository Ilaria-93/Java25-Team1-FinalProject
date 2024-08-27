package com.example.team_project.services;

import com.example.team_project.entities.Bank;
import com.example.team_project.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    // Creates new banks
    public List<Bank> createBanks(List<Bank> banks) {
        return bankRepository.saveAll(banks);
    }

    // Retrieves the list of all banks
    public List<Bank> listBanks() {
        return bankRepository.findAll();
    }

    // Retrieves a single bank by its ID
    public Optional<Bank> getBankById(Integer id) {
        return bankRepository.findById(id);
    }

    // Updates the information of a bank
    public Bank updateBank(Integer id, Bank updatedBank) {
        if (bankRepository.existsById(id)) {
            updatedBank.setId(id); // Ensure the ID is set
            return bankRepository.save(updatedBank);
        } else {
            throw new IllegalStateException("Bank not found");
        }
    }

    // Deletes a specific bank by its ID
    public void deleteBankById(Integer id) {
        if (bankRepository.existsById(id)) {
            bankRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Bank not found");
        }
    }
}
