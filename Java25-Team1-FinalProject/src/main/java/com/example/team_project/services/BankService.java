package com.example.team_project.services;

import com.example.team_project.entities.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private Bank bank;
}
