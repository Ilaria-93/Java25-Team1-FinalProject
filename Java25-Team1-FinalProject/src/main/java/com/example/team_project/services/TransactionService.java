package com.example.team_project.services;

import com.example.team_project.entities.Transaction;
import com.example.team_project.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Create a new transaction
    public Transaction createNewTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Get a list of all transactions
    public List<Transaction> listTransactions() {
        return transactionRepository.findAll();
    }

    // Find a transaction by its ID
    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }

    // Update an existing transaction by its ID
    public Transaction updateTransaction(Integer id, Transaction transactionDetails) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            transaction.setAmount(transactionDetails.getAmount());
            transaction.setDate(transactionDetails.getDate());
            transaction.setType(transactionDetails.getType());
            return transactionRepository.save(transaction);
        } else {
            throw new IllegalStateException("Transaction not found");
        }
    }

    // Delete a transaction by its ID
    public void deleteTransaction(Integer id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Transaction not found");
        }
    }
}