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
    public Optional<Transaction> updateTransaction(Integer id, Transaction updatedtransaction) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            optionalTransaction.get().setType(updatedtransaction.getType());
            optionalTransaction.get().setStatus(updatedtransaction.getStatus());
            optionalTransaction.get().setAmount(updatedtransaction.getAmount());
            optionalTransaction.get().setDate(updatedtransaction.getDate());
            optionalTransaction.get().setFromAccount(updatedtransaction.getFromAccount());
            transactionRepository.save(optionalTransaction.get());
            return optionalTransaction;
        } else {
            return Optional.empty();
        }
    }

    // Delete a transaction by its ID
    public void deleteTransaction(Integer id) {
       transactionRepository.deleteById(id);
    }
}