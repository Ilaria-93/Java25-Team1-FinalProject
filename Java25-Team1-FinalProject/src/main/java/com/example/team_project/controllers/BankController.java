package com.example.team_project.controllers;

import com.example.team_project.entities.Bank;
import com.example.team_project.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    // Create new bank
    @PostMapping("/create")
    public Bank createBank(@RequestBody Bank bank) {
        return bankService.createBank(bank);
    }

    // Retrieve the list of all banks
    @GetMapping("/list")
    public List<Bank> listBanks() {
        return bankService.listBanks();
    }

    // Retrieve a single bank by its ID
    @GetMapping("/search/{id}")
    public ResponseEntity<Bank> searchBankById(@PathVariable Integer id) {
        Optional<Bank> bank = bankService.searchBankById(id);
        if (bank.isPresent()) {
            return ResponseEntity.ok(bank.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Update the information of a bank
    @PutMapping("/update/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable Integer id, @RequestBody Bank bank) {
        Optional<Bank> currentBank = bankService.updateBank(id, bank);
        if (currentBank.isPresent()) {
            return ResponseEntity.ok(currentBank.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a specific bank by its ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Integer id) {
        Optional<Bank> currentBank = bankService.searchBankById(id);
        if (currentBank.isPresent()) {
            bankService.deleteBank(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
