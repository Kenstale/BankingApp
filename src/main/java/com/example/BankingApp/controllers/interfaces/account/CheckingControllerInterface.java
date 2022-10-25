package com.example.BankingApp.controllers.interfaces.account;

import com.example.BankingApp.controllers.dto.CheckingDTO;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.Checking;

import java.util.List;

public interface CheckingControllerInterface {
    List<Checking> getAllCheckingAccounts();
    Account getCheckingAccount(Long id);
    Account createNewAccount(CheckingDTO checkingDTO);
    void delete(Long id);
}
