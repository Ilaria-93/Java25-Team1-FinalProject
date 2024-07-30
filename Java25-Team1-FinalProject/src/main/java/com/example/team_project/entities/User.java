package com.example.team_project.entities;

import com.example.team_project.enumerated.DocumentEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false)
    private DocumentEnum documentType;

    @Column(name = "employee_role", nullable = false)
    private String employeeRole;

    @Column(name = "bank_location", nullable = false)
    private String bankLocation;

    @Column(name = "phone")
    private String phone;

    public User() {
    }

    public User(String bankLocation, DocumentEnum documentType, String email, String employeeRole, String firstName, Long id, boolean isActive, String lastName, String phone) {
        this.bankLocation = bankLocation;
        this.documentType = documentType;
        this.email = email;
        this.employeeRole = employeeRole;
        this.firstName = firstName;
        this.id = id;
        this.isActive = isActive;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getBankLocation() {
        return bankLocation;
    }

    public void setBankLocation(String bankLocation) {
        this.bankLocation = bankLocation;
    }

    public DocumentEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentEnum documentType) {
        this.documentType = documentType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "bankLocation='" + bankLocation + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", documentType=" + documentType +
                ", employeeRole='" + employeeRole + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}