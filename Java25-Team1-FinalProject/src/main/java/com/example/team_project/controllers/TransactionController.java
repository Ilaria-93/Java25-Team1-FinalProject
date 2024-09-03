package com.example.team_project.controllers;

import com.example.team_project.entities.Transaction;
import com.example.team_project.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Create a new transaction
    @PostMapping("/create")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    // Get a list of all transactions
    @GetMapping("/list")
    public List<Transaction> listTransactions() {
        return transactionService.listTransactions();
    }

    // Get a transaction by ID
    @GetMapping("/search/{id}")
    public ResponseEntity<Transaction> searchTransactionById(@PathVariable Integer id) {
        Optional<Transaction> transaction = transactionService.searchTransactionById(id);
        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Update a transaction by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction) {
        Optional<Transaction> currentTransaction = transactionService.updateTransaction(id, transaction);
        if (currentTransaction.isPresent()) {
            return ResponseEntity.ok(currentTransaction.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a transaction by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
        Optional<Transaction> transaction = transactionService.searchTransactionById(id);
        if (transaction.isPresent()) {
            transactionService.deleteTransaction(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}



