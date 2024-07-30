package com.example.team_project.enumerated;

public class BankAccountEnum {


    public enum BankAccountType {
        CHECKING,
        SAVINGS,
        CREDIT_CARD,
        LOAN
    }


    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER,
        PAYMENT
    }


    public enum TransactionStatus {
        PENDING,
        COMPLETED,
        FAILED,
        CANCELLED
    }

}