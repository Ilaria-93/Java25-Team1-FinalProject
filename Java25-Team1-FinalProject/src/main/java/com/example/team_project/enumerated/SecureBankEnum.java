package com.example.team_project.enumerated;

public class SecureBankEnum {

    public enum AccountType {
        CHECKING,
        SAVINGS,
        EMPLOYEE,
        CUSTOMERS
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