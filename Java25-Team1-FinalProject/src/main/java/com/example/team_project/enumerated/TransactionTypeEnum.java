package com.example.team_project.enumerated;

public enum TransactionTypeEnum {

    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal"),
    TRANSFER("Transfer"),
    PAYMENT("Payment"),
    REFUND("Refund"),
    CHARGE("Charge"),
    FEE("Fee"),
    INTEREST_CREDIT("Interest Credit"),
    INTEREST_DEBIT("Interest Debit"),
    CASH_ADVANCE("Cash Advance"),
    BALANCE_TRANSFER("Balance Transfer"),
    ONLINE_PURCHASE("Online Purchase"),
    ATM_WITHDRAWAL("ATM Withdrawal");

    private final String description;

    TransactionTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

