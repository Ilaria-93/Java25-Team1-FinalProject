package com.example.team_project.enumerated;

public enum TransactionStatusEnum {

    ACCEPTED("Accepted"),
    DECLINED("Declined"),
    PENDING("Pending"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    IN_PROGRESS("In Progress"),
    REVERSED("Reversed"),
    ON_HOLD("On Hold"),
    UNDER_REVIEW("Under Review");

    private final String description;

    TransactionStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
