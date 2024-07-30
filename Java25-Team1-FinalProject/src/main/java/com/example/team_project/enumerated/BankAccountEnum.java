package com.example.team_project.enumerated;

public class BankAccountEnum {


    public enum BankAccountType {
        CHECKING,
        SAVINGS,
        CREDIT_CARD,
        LOAN
    }
    private String descrizione;

    BankAccountEnum(String descrizione){
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}




