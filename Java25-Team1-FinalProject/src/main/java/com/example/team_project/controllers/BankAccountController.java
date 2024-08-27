package com.example.team_project.controllers;

import com.example.team_project.entities.BankAccount;
import com.example.team_project.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bankaccounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    // Create new bank accounts
    @PostMapping("/create")
    public ResponseEntity<List<BankAccount>> createBankAccounts(@RequestBody List<BankAccount> bankAccounts) {
        List<BankAccount> createdAccounts = bankAccountService.createBankAccounts(bankAccounts);
        return ResponseEntity.ok(createdAccounts);
    }

    // Retrieve the list of all bank accounts
    @GetMapping("/list")
    public ResponseEntity<List<BankAccount>> listBankAccounts() {
        List<BankAccount> accounts = bankAccountService.listBankAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Retrieve a single bank account by its ID
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Integer id) {
        Optional<BankAccount> bankAccount = bankAccountService.findBankAccountById(id);
        if (bankAccount.isPresent()) {
            return ResponseEntity.ok(bankAccount.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a specific bank account by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAccountById(@PathVariable Integer id) {
        try {
            bankAccountService.deleteBankAccountById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Deposit a specified amount into a bank account
    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<BankAccount> deposit(@PathVariable Integer accountId, @RequestBody BigDecimal amount) {
        BankAccount updatedAccount = bankAccountService.deposit(accountId, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    // Withdraw a specified amount from a bank account
    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<BankAccount> withdraw(@PathVariable Integer accountId, @RequestBody BigDecimal amount) {
        BankAccount updatedAccount = bankAccountService.withdraw(accountId, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    // Transfer a specified amount between two bank accounts
    @PostMapping("/transfer")
    public ResponseEntity<BankAccount> transfer(
            @RequestParam Integer fromAccountId,
            @RequestParam Integer toAccountId,
            @RequestBody BigDecimal amount) {
        BankAccount updatedToAccount = bankAccountService.transfer(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok(updatedToAccount);
    }

    // Apply interest to a bank account based on its type
    @PostMapping("/{accountId}/apply-interest")
    public ResponseEntity<BankAccount> applyInterest(@PathVariable Integer accountId) {
        BankAccount updatedAccount = bankAccountService.applyInterest(accountId);
        return ResponseEntity.ok(updatedAccount);
    }

    // Check the balance of a bank account
    @GetMapping("/{accountId}/balance")
    public ResponseEntity<BigDecimal> checkBalance(@PathVariable Integer accountId) {
        BigDecimal balance = bankAccountService.checkBalance(accountId);
        return ResponseEntity.ok(balance);
    }
}
