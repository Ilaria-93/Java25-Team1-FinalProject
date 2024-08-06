package com.example.team_project.enumerated;

public enum DocumentTypeEnum {

    IDENTITY_CARD("Identity Card"),
    PASSPORT("Passport"),
    DRIVER_LICENSE("Driver License");

    private final String description;

    DocumentTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
