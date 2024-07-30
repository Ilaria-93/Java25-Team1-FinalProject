package com.example.team_project.entities;

import com.example.team_project.enumerated.TransactionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private TransactionEnum transactionType;

    @Column
    private BigDecimal amount;

    @Column
    private TransactionEnum status;

    @Column
    private LocalDateTime date;

    @Column
    private String fromAccount;

    @Column
    private String toAccount;

    public Transaction() {
    }

    public Transaction(Long id, TransactionEnum transactionType, BigDecimal amount, TransactionEnum status, LocalDateTime date, String fromAccount, String toAccount) {
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

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
}

