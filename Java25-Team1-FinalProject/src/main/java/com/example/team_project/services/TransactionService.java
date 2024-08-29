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
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Get a list of all transactions
    public List<Transaction> listTransactions() {
        return transactionRepository.findAll();
    }

    // Find a transaction by its ID
    public Optional<Transaction> searchTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }

    // Update an existing transaction by its ID
    public Optional<Transaction> updateTransaction(Integer id, Transaction transaction) {
        Optional<Transaction> currentTransactionOpt = transactionRepository.findById(id);
        if (currentTransactionOpt.isPresent()) {
            currentTransactionOpt.get().setType(transaction.getType());
            currentTransactionOpt.get().setStatus(transaction.getStatus());
            currentTransactionOpt.get().setAmount(transaction.getAmount());
            currentTransactionOpt.get().setDate(transaction.getDate());
            currentTransactionOpt.get().setFromAccount(transaction.getFromAccount());

            transactionRepository.save(currentTransactionOpt.get());
            return currentTransactionOpt;
        } else {
            return Optional.empty();
        }
    }

    // Delete a transaction by its ID
    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}