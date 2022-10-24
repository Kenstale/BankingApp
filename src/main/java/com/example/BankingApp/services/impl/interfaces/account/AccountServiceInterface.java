package com.example.BankingApp.services.impl.interfaces.account;

import com.example.BankingApp.controllers.dto.BalanceDTO;
import com.example.BankingApp.controllers.dto.StatusDTO;
import com.example.BankingApp.models.Accounts.Account;

import java.util.List;

public interface AccountServiceInterface {
    Account getAccount(Long id);
    List<Account> getAllAccountHolderAccounts(String username);
    void updateAccountBalance(Long id, BalanceDTO balance);
    void changeStatus(Long id, StatusDTO statusDTO);
}
