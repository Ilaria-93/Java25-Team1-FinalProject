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

    // Creates new banks
    @PostMapping("/create")
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank createdBank = bankService.createBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);
    }

    // Retrieves the list of all banks
    @GetMapping("/list")
    public List<Bank> listBanks() {
        return bankService.listBanks();
    }

    // Retrieves a single bank by its ID
    @GetMapping("/search/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Integer id) {
        Optional<Bank> bank = bankService.getBankById(id);
        if (bank.isPresent()) {
            return ResponseEntity.ok(bank.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Updates the information of a bank
    @PutMapping("/update/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable Integer id, @RequestBody Bank updatedBank) {
        Optional<Bank> bank = bankService.updateBank(id, updatedBank);
        if (bank.isPresent()){
            return ResponseEntity.ok(bank.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletes a specific bank by its ID
    // TODO sistema metodo
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBankById(@PathVariable Integer id) {
        try {
            bankService.deleteBankById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
