package com.example.team_project.services;

import com.example.team_project.entities.BankAccount;
import com.example.team_project.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount createNewBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public List<BankAccount> listBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount deposit(Integer accountId, BigDecimal amount) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalStateException("Account not found"));
        bankAccount.setBalance(bankAccount.getBalance().add(amount));
        bankAccount.setUpdatedAt(LocalDateTime.now());
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount withdraw(Integer accountId, BigDecimal amount) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalStateException("Account not found"));
        if (bankAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds");
        }
        bankAccount.setBalance(bankAccount.getBalance().subtract(amount));
        bankAccount.setUpdatedAt(LocalDateTime.now());
        return bankAccountRepository.save(bankAccount);
    }
}
