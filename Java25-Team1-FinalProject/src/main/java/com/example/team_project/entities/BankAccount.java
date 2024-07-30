package com.example.team_project.entities;

import com.example.team_project.enumerated.BankAccountEnum;
import com.example.team_project.enumerated.UserEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// TODO separare classe? Credit Card, Loan, etc.
@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BankAccountEnum accountType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserEnum status;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public BankAccount() {
    }

    public BankAccount(Integer id, String accountNumber, BankAccountEnum accountType, UserEnum status, BigDecimal balance, LocalDateTime createdAt, LocalDateTime updatedAt, User user) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.status = status;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(BankAccountEnum accountType) {
        this.accountType = accountType;
    }

    public UserEnum getStatus() {
        return status;
    }

    public void setStatus(UserEnum status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
