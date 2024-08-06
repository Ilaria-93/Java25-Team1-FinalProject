package com.example.team_project.enumerated;

public enum UserStatusEnum {

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    BLOCKED("Blocked"),
    CLOSED("Closed");

    private final String status;

    UserStatusEnum(String description) {
        this.status = description;
    }

    public String getStatus() {
        return status;
    }
}
