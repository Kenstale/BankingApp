package com.example.BankingApp.controllers.interfaces.account;

import com.example.BankingApp.controllers.dto.SavingsDTO;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.Savings;

import java.util.List;

public interface SavingsControllerInterface {

    List<Savings> getAllSavingsAccounts();
    Savings getSavingsAccount(Long id);
    Account createNewAccount(SavingsDTO savingsDTO);
    void delete(Long id);

}
