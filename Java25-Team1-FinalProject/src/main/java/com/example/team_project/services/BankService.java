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
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    // Retrieves the list of all banks
    public List<Bank> listBanks() {
        return bankRepository.findAll();
    }

    // Retrieves a single bank by its ID
    public Optional<Bank> searchBankById(Integer id) {
        return bankRepository.findById(id);
    }

    // Updates the information of a bank
    public Optional<Bank> updateBank(Integer id, Bank bank) {
        Optional<Bank> currentBankOpt = bankRepository.findById(id);
        if (currentBankOpt.isPresent()) {
            currentBankOpt.get().setSwiftCode(bank.getSwiftCode());
            currentBankOpt.get().setName(bank.getName());
            currentBankOpt.get().setLocation(bank.getLocation());
            currentBankOpt.get().setEmail(bank.getEmail());
            currentBankOpt.get().setPhone(bank.getPhone());
            currentBankOpt.get().setOpeningHours(bank.getOpeningHours());

            bankRepository.save(currentBankOpt.get());
            return currentBankOpt;
        } else {
            return Optional.empty();
        }
    }

    // Deletes a specific bank by its ID
    public void deleteBank(Integer id) {
        bankRepository.deleteById(id);
    }
}
