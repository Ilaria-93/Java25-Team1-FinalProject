package com.example.team_project.entities;

import com.example.team_project.enumerated.DocumentEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false)
    private DocumentEnum documentType;

    @Column(name = "document_number", nullable = false)
    private String documentNumber;

    @Column(name = "employee_role", nullable = false)
    private String employeeRole;

    @Column(name = "bank_location", nullable = false)
    private String bankLocation;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public User() {
    }

    public User(Long id, String email, String firstName, String lastName, String phone, DocumentEnum documentType, String documentNumber, String employeeRole, String bankLocation, boolean isActive) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.employeeRole = employeeRole;
        this.bankLocation = bankLocation;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public DocumentEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentEnum documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getBankLocation() {
        return bankLocation;
    }

    public void setBankLocation(String bankLocation) {
        this.bankLocation = bankLocation;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", documentType=" + documentType +
                ", documentNumber='" + documentNumber + '\'' +
                ", employeeRole='" + employeeRole + '\'' +
                ", bankLocation='" + bankLocation + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}