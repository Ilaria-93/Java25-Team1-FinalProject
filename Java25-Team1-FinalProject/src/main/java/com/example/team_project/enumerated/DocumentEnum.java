package com.example.team_project.enumerated;

public enum DocumentEnum {

    IDENTITY_CARD("Identity Card"),
    PASSPORT("Passport"),
    DRIVER_LICENSE("Driver License");

    private String descrizione;

    DocumentEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
