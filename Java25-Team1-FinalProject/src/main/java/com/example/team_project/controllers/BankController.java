package com.example.team_project.controllers;

import com.example.team_project.entities.Bank;
import com.example.team_project.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    // Creates new banks
    @PostMapping
    public List<Bank> createBanks(@RequestBody List<Bank> banks) {
        return bankService.createBanks(banks);
    }

    // Retrieves the list of all banks
    @GetMapping
    public List<Bank> listBanks() {
        return bankService.listBanks();
    }

    // Retrieves a single bank by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Integer id) {
        Optional<Bank> bank = bankService.getBankById(id);
        if (bank.isPresent()) {
            return ResponseEntity.ok(bank.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Updates the information of a bank
    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable Integer id, @RequestBody Bank updatedBank) {
        try {
            Bank bank = bankService.updateBank(id, updatedBank);
            return ResponseEntity.ok(bank);
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletes a specific bank by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankById(@PathVariable Integer id) {
        try {
            bankService.deleteBankById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
