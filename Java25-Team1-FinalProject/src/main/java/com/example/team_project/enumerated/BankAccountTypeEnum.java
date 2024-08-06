package com.example.team_project.enumerated;

public enum BankAccountTypeEnum {

    CHECKING("Checking", 0.01, 0),
    SAVINGS("Savings", 0.02, 0),
    CREDIT_CARD("Credit Card", 0.0, 50000),
    DEBIT_CARD("Debit Card", 0.0, 25000),
    LOAN("Loan", 0.05, 0),
    CERTIFICATE_OF_DEPOSIT("Certificate of Deposit", 0.04, 0),
    BUSINESS_CHECKING("Business Checking", 0.01, 0),
    BUSINESS_SAVINGS("Business Savings", 0.02, 0),
    STUDENT_CHECKING("Student Checking", 0.01, 0),
    RETIREMENT_ACCOUNT("Retirement Account", 0.04, 0);

    private final String description;
    private final Double interestRate;
    private final Integer creditLimit;

    BankAccountTypeEnum (String description, Double interestRate, Integer creditLimit) {
        this.description = description;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
    }

    public String getDescription() {
        return description;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }
}




