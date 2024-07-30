package com.example.team_project.enumerated;

public class BankAccountEnum {

    // TODO sistemare gli enumerati nelle corrispettive classi
    public enum BankAccountType {
        CHECKING,
        SAVINGS,
        CREDIT_CARD,
        LOAN
    }

    // TODO cancellazione logica (RecordStatusEnum)
    public enum AccountStatus {
        ACTIVE,
        INACTIVE,
        BLOCKED,
        CLOSED
    }


    public enum UserRole {
        CLIENT,
        EMPLOYEE,
        ADMIN
    }


    public enum DocumentType {
        IDENTITY_CARD,
        PASSPORT,
        DRIVER_LICENSE
    }
}