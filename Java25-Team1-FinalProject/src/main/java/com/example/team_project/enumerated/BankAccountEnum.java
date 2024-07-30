package com.example.team_project.enumerated;

public enum BankAccountEnum {

    CHECKING("Checking"),
    SAVINGS("Savings"),
    CREDIT_CARD("Credit Card"),
    LOAN("Loan");

    private final String descrizione;

    BankAccountEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}




