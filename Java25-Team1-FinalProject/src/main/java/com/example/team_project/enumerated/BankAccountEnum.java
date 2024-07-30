package com.example.team_project.enumerated;

public enum BankAccountEnum {

    CHECKING("Checking", 0.01, 0),
    SAVINGS("Savings", 0.02, 0),
    CREDIT_CARD("Credit Card", 0.0, 50000),
    DEBIT_CARD("Debit Card", 0.0, 25000),
    LOAN("Loan", 0.05, 0);

    private final String descrizione;
    private final Double interestRate;
    private final Integer creditLimit;

    BankAccountEnum(String descrizione, Double interestRate, Integer creditLimit) {
        this.descrizione = descrizione;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }
}




