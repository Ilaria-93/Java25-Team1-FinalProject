package com.example.team_project.services;

import com.example.team_project.entities.BankAccount;
import com.example.team_project.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    // Creates new bank accounts
    public BankAccount createBankAccount(BankAccount bankAccount) {
        if (bankAccount.getBalance() == null) {
            bankAccount.setBalance(BigDecimal.ZERO);
        } else { bankAccount.setBalance(bankAccount.getBalance().setScale(2, RoundingMode.UP));
        }
        return bankAccountRepository.save(bankAccount);
    }

    // Retrieves the list of all bank accounts
    public List<BankAccount> listBankAccounts() {
        return bankAccountRepository.findAll();
    }

    // Retrieves a single bank account by its ID
    public Optional<BankAccount> searchBankAccountById(Integer id) {
        if (bankAccountRepository.existsById(id)) {
            return bankAccountRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    // Update an existing user by their ID
    public Optional<BankAccount> updateBankAccount(Integer id, BankAccount bankAccount) {
        Optional<BankAccount> currentBankAccountOpt = bankAccountRepository.findById(id);
        if (currentBankAccountOpt.isPresent()) {
            currentBankAccountOpt.get().setAccountNumber(bankAccount.getAccountNumber());
            currentBankAccountOpt.get().setAccountType(bankAccount.getAccountType());
            currentBankAccountOpt.get().setStatus(bankAccount.getStatus());
            currentBankAccountOpt.get().setBalance(bankAccount.getBalance());
            currentBankAccountOpt.get().setCreatedAt(bankAccount.getCreatedAt());
            currentBankAccountOpt.get().setUpdatedAt(bankAccount.getUpdatedAt());
            currentBankAccountOpt.get().setUser(bankAccount.getUser());
            currentBankAccountOpt.get().setBank(bankAccount.getBank());

            bankAccountRepository.save(currentBankAccountOpt.get());
            return currentBankAccountOpt;
        } else {
            return Optional.empty();
        }
    }

    // Deletes a specific bank account by its ID
    public void deleteBankAccount(Integer id) {
        bankAccountRepository.deleteById(id);
    }

    // Deposits a specified amount into a bank account
    public Optional<BankAccount> deposit(Integer accountId, BigDecimal amount) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if (optionalBankAccount.isEmpty()) {
            return Optional.empty();
        }
        BankAccount bankAccount = optionalBankAccount.get();
        bankAccount.setBalance(bankAccount.getBalance().add(amount));
        bankAccount.setUpdatedAt(LocalDateTime.now());
        BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount);
        return Optional.of(updatedBankAccount);
    }

    // Withdraws a specified amount from a bank account
    public Optional<BankAccount> withdraw(Integer accountId, BigDecimal amount) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if (optionalBankAccount.isEmpty()) {
            return Optional.empty();
        }

        BankAccount bankAccount = optionalBankAccount.get();
        if (bankAccount.getBalance().compareTo(amount) < 0) {
            return Optional.empty();
        }

        bankAccount.setBalance(bankAccount.getBalance().subtract(amount));
        bankAccount.setUpdatedAt(LocalDateTime.now());
        BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount);
        return Optional.of(updatedBankAccount);
    }


    // Method to transfer a certain amount between two bank accounts
    public Optional<BankAccount> transfer(Integer fromAccountId, Integer toAccountId, BigDecimal amount) {
        Optional<BankAccount> optionalFromAccount = bankAccountRepository.findById(fromAccountId);
        Optional<BankAccount> optionalToAccount = bankAccountRepository.findById(toAccountId);

        if (optionalFromAccount.isEmpty() || optionalToAccount.isEmpty()) {
            return Optional.empty();
        }
        BankAccount fromAccount = optionalFromAccount.get();
        BankAccount toAccount = optionalToAccount.get();

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            return Optional.empty();
        }
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        fromAccount.setUpdatedAt(LocalDateTime.now());
        toAccount.setUpdatedAt(LocalDateTime.now());

        bankAccountRepository.save(fromAccount);
        bankAccountRepository.save(toAccount);

        return Optional.of(toAccount);
    }

    // Method to apply interest to a bank account based on its type
    public Optional<BankAccount> applyInterest(Integer accountId) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if (optionalBankAccount.isEmpty()) {
            return Optional.empty();
        }

        BankAccount bankAccount = optionalBankAccount.get();
        BigDecimal interest = bankAccount.getBalance()
                .multiply(BigDecimal.valueOf(bankAccount.getAccountType().getInterestRate()));
        bankAccount.setBalance(bankAccount.getBalance().add(interest));
        bankAccount.setUpdatedAt(LocalDateTime.now());

        BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount);
        return Optional.of(updatedBankAccount);
    }


    // Method to check the balance of a bank account
    public Optional<BigDecimal> checkBalance(Integer accountId) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if (optionalBankAccount.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(optionalBankAccount.get().getBalance());
    }
}
