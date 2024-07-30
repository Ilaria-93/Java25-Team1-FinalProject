package com.example.team_project.enumerated;

public class UserEnum {


    public enum AccountStatus {
        ACTIVE,
        INACTIVE,
        BLOCKED,
        CLOSED

    }

    public enum UserRole {
        USER,
        EMPLOYEE,
        ADMIN
    }


    private String descrizione;

    UserEnum(String descrizione){
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
