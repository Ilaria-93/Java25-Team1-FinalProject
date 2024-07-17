package com.example.team_project.repositories;

import com.example.team_project.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
}