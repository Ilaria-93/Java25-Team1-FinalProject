package com.example.team_project.enumerated;

public class BankingEnum {

    public enum AccountType {
        CHECKING,
        SAVINGS,
        CREDIT_CARD,
        LOAN
    }

    public enum AccountStatus {
        ACTIVE,
        INACTIVE,
        BLOCKED,
        CLOSED
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER,
        PAYMENT
    }

    public enum UserRole {
        CLIENT,
        EMPLOYEE,
        ADMIN
    }

    public enum TransactionStatus {
        PENDING,
        COMPLETED,
        FAILED,
        CANCELLED
    }

    public enum NotificationType {
        EMAIL,
        SMS,
        PUSH_NOTIFICATION
    }
}