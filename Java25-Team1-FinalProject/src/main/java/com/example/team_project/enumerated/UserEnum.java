package com.example.team_project.enumerated;

public enum UserEnum {

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    BLOCKED("Blocked"),
    CLOSED("Closed"),

    USER("User"),
    EMPLOYEE("Employee"),
    ADMIN("Admin");

    private final String descrizione;

    UserEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
