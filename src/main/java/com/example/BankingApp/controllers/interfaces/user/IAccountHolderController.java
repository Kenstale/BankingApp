package com.example.BankingApp.controllers.interfaces.user;

import com.example.BankingApp.controllers.dto.AccountHolderDTO;
import com.example.BankingApp.models.users.AccountHolder;
import com.example.BankingApp.models.users.User;

import java.util.List;

public interface IAccountHolderController {
    List<AccountHolder> getAllAccountHolders();
    User getAccountHolder(Long id);
    AccountHolder addAccountHolder(AccountHolderDTO accountHolderDTO);
    void delete(Long id);
}
