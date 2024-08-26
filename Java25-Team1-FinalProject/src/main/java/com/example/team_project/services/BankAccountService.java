package com.example.team_project.services;

import com.example.team_project.entities.BankAccount;
import com.example.team_project.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    // Creates new bank accounts
    public List<BankAccount> createBankAccounts(List<BankAccount> bankAccounts) {
        return bankAccountRepository.saveAll(bankAccounts);
    }

    // Retrieves the list of all bank accounts
    public List<BankAccount> listBankAccounts() {
        return bankAccountRepository.findAll();
    }

    // Retrieves a single bank account by its ID
    public Optional<BankAccount> findBankAccountById(Long id) {
        if (bankAccountRepository.existsById(Math.toIntExact(id))) {
            return bankAccountRepository.findById(Math.toIntExact(id));
        } else {
            return Optional.empty();
        }
    }

    // Deletes a specific bank account by its ID
    public void deleteBankAccountById(Long id) {
        if (bankAccountRepository.existsById(Math.toIntExact(id))) {
            bankAccountRepository.deleteById(Math.toIntExact(id));
        }
    }

    // Deposits a specified amount into a bank account
    public BankAccount deposit(Long accountId, BigDecimal amount) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(Math.toIntExact(accountId));
        if (optionalBankAccount.isEmpty()) {
            throw new IllegalStateException("Account not found");
        }
        BankAccount bankAccount = optionalBankAccount.get();
        bankAccount.setBalance(bankAccount.getBalance().add(amount));
        bankAccount.setUpdatedAt(LocalDateTime.now());
        return bankAccountRepository.save(bankAccount);
    }

    // Withdraws a specified amount from a bank account
    public BankAccount withdraw(Long accountId, BigDecimal amount) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(Math.toIntExact(accountId));
        if (optionalBankAccount.isEmpty()) {
            throw new IllegalStateException("Account not found");
        }
        BankAccount bankAccount = optionalBankAccount.get();
        if (bankAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds");
        }
        bankAccount.setBalance(bankAccount.getBalance().subtract(amount));
        bankAccount.setUpdatedAt(LocalDateTime.now());
        return bankAccountRepository.save(bankAccount);
    }

    // Method to transfer a certain amount between two bank accounts
    public BankAccount transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        Optional<BankAccount> optionalFromAccount = bankAccountRepository.findById(Math.toIntExact(fromAccountId));
        if (optionalFromAccount.isEmpty()) {
            throw new IllegalStateException("Source account not found");
        }
        Optional<BankAccount> optionalToAccount = bankAccountRepository.findById(Math.toIntExact(toAccountId));
        if (optionalToAccount.isEmpty()) {
            throw new IllegalStateException("Destination account not found");
        }

        BankAccount fromAccount = optionalFromAccount.get();
        BankAccount toAccount = optionalToAccount.get();

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        bankAccountRepository.save(fromAccount);
        return bankAccountRepository.save(toAccount);
    }

    // Method to apply interest to a bank account based on its type
    public BankAccount applyInterest(Long accountId) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(Math.toIntExact(accountId));
        if (optionalBankAccount.isEmpty()) {
            throw new IllegalStateException("Account not found");
        }

        BankAccount bankAccount = optionalBankAccount.get();
        BigDecimal interest = bankAccount.getBalance()
                .multiply(BigDecimal.valueOf(bankAccount.getAccountType().getInterestRate()));
        bankAccount.setBalance(bankAccount.getBalance().add(interest));
        bankAccount.setUpdatedAt(LocalDateTime.now());

        return bankAccountRepository.save(bankAccount);
    }

    // Method to check the balance of a bank account
    public BigDecimal checkBalance(Long accountId) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(Math.toIntExact(accountId));
        if (optionalBankAccount.isEmpty()) {
            throw new IllegalStateException("Account not found");
        }
        return optionalBankAccount.get().getBalance();
    }
}
