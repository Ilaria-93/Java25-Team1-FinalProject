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
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true)
    private Integer accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private BankAccountEnum accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserEnum status;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public BankAccount() {
    }

    public BankAccount(Long id, Integer accountNumber, BankAccountEnum accountType, UserEnum status, BigDecimal balance, LocalDateTime createdAt, LocalDateTime updatedAt, User user) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.status = status;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
