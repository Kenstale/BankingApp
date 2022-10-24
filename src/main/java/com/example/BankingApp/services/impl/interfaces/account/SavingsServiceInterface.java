package com.example.BankingApp.services.impl.interfaces.account;

import com.example.BankingApp.controllers.dto.SavingsDTO;
import com.example.BankingApp.models.Accounts.Savings;

public interface SavingsServiceInterface {
    Savings getSavingsAccount(Long id);
    Savings createNewAccount(SavingsDTO savingsDTO);
}
