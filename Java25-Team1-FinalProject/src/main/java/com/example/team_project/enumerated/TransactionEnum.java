package com.example.team_project.enumerated;

public enum TransactionEnum {

    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal"),
    TRANSFER("Trasfer"),
    PAYMENT("Payment"),

    ACCEPTED("Accepted"),
    DECLINED("Declined"),
    PENDING("Pending"),

    //TODO Currency vale sia per l'Entity Transaction e BankAccount, chiedere se fare un enum separato
    CURRENCY_EURO("€"),
    CURRENCY_DOLLAR("$");

    private final String descrizione;

    TransactionEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}

