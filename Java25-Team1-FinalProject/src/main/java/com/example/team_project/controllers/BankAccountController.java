package com.example.team_project.controllers;

import com.example.team_project.entities.BankAccount;
import com.example.team_project.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        List<BankAccount> bankAccounts = bankAccountService.listBankAccounts();
        return ResponseEntity.ok(bankAccounts);
    }

    // Retrieve a single bank account by its ID
    @GetMapping("/search/{id}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Integer id) {
        Optional<BankAccount> bankAccount = bankAccountService.findBankAccountById(id);
        if (bankAccount.isPresent()) {
            return ResponseEntity.ok(bankAccount.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a specific bank account by its ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBankAccountById(@PathVariable Integer id) {
        if (bankAccountService.findBankAccountById(id).isPresent()) {
            bankAccountService.deleteBankAccountById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Deposit a specified amount into a bank account
    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<BankAccount> deposit(@PathVariable Integer id, @RequestParam BigDecimal amount) {
        Optional<BankAccount> optBankAccount = bankAccountService.deposit(id, amount);

        if (optBankAccount.isPresent()){
            return ResponseEntity.ok(optBankAccount.get());
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Withdraws a specified amount from a bank account
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<BankAccount> withdraw(@PathVariable Integer id, @RequestParam BigDecimal amount) {
        Optional<BankAccount> optionalBankAccount = bankAccountService.withdraw(id, amount);

        if (optionalBankAccount.isPresent()) {
            return ResponseEntity.ok(optionalBankAccount.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Transfers a certain amount between two bank accounts
    @PostMapping("/transfer")
    public ResponseEntity<BankAccount> transfer(
            @RequestParam Integer fromAccountId,
            @RequestParam Integer toAccountId,
            @RequestParam BigDecimal amount) {
        Optional<BankAccount> optionalToAccount = bankAccountService.transfer(fromAccountId, toAccountId, amount);
        if (optionalToAccount.isPresent()) {
            return ResponseEntity.ok(optionalToAccount.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Applies interest to a bank account based on its type
    @PostMapping("/{id}/apply-interest")
    public ResponseEntity<BankAccount> applyInterest(@PathVariable Integer id) {
        Optional<BankAccount> optionalBankAccount = bankAccountService.applyInterest(id);

        if (optionalBankAccount.isPresent()) {
            return ResponseEntity.ok(optionalBankAccount.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Checks the balance of a bank account
    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> checkBalance(@PathVariable Integer id) {
        Optional<BigDecimal> optionalBalance = bankAccountService.checkBalance(id);

        if (optionalBalance.isPresent()) {
            return ResponseEntity.ok(optionalBalance.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}