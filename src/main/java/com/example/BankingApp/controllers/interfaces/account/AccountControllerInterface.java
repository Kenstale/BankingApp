package com.example.BankingApp.controllers.interfaces.account;

import com.example.BankingApp.controllers.dto.BalanceDTO;
import com.example.BankingApp.controllers.dto.StatusDTO;
import com.example.BankingApp.models.Accounts.Account;

import java.util.List;

public interface AccountControllerInterface {
    List<Account> getAllAccounts();
    Account getAccount(Long id);
    //List<Account> getAllAccountHolderAccounts(UserDetails userDetails);
    void updateBalance(Long id, BalanceDTO balanceDTO);
    void changeStatus(Long id, StatusDTO statusDTO);
    void deleteAccount(Long id);
}
