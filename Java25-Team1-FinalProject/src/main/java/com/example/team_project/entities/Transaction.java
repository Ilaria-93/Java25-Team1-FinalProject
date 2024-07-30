package com.example.team_project.entities;

import com.example.team_project.enumerated.TransactionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "transaction_type", nullable = false)
    private TransactionEnum transactionType;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "status", nullable = false)
    private TransactionEnum status;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "from_account", nullable = false)
    private BankAccount fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account", nullable = false)
    private BankAccount toAccount;

    public Transaction() {
    }

    public Transaction(Long id, TransactionEnum transactionType, BigDecimal amount, TransactionEnum status, LocalDateTime date, BankAccount fromAccount, BankAccount toAccount) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
        this.status = status;
        this.date = date;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionEnum transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionEnum status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BankAccount getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(BankAccount fromAccount) {
        this.fromAccount = fromAccount;
    }

    public BankAccount getToAccount() {
        return toAccount;
    }

    public void setToAccount(BankAccount toAccount) {
        this.toAccount = toAccount;
    }
}

