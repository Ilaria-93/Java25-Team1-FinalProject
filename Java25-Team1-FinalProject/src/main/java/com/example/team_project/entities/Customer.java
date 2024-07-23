package com.example.team_project.entities;

import com.example.team_project.enumerated.BankingEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

    @Column(name = "phone")
    private String phone;

    public Customer() {
        super();
    }

    public Customer(Long id, String email, String firstName, String lastName, boolean isActive, BankingEnum.DocumentType documentType, String phone) {
        super(id, email, firstName, lastName, isActive, documentType);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
