package com.example.team_project.entities;

import com.example.team_project.enumerated.BankingEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends User {

    @Column(name = "employee_role", nullable = false)
    private String employeeRole;

    @Column(name = "bank_location", nullable = false)
    private String bankLocation;

    public Employee() {
        super();
    }

    public Employee(Long id, String email, String firstName, String lastName, boolean isActive, BankingEnum.DocumentType documentType, String employeeRole, String bankLocation) {
        super(id, email, firstName, lastName, isActive, documentType);
        this.employeeRole = employeeRole;
        this.bankLocation = bankLocation;
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
}
