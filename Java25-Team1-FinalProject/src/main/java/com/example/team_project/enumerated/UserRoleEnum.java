package com.example.team_project.enumerated;

public enum UserRoleEnum {

    USER("User"),
    EMPLOYEE("Employee"),
    ADMIN("Admin");

    private final String description;

    UserRoleEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
