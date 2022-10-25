package com.example.BankingApp.services.impl.interfaces.user;

import com.example.BankingApp.controllers.dto.AccountHolderDTO;
import com.example.BankingApp.controllers.dto.TransactionDTO;
import com.example.BankingApp.models.operation.Transaction;
import com.example.BankingApp.models.users.AccountHolder;
import com.example.BankingApp.models.users.User;
import org.springframework.stereotype.Service;

@Service
public interface IAccountHolderService {
    User getUser(Long id);
    AccountHolder addAccountHolder(AccountHolderDTO accountHolderDTO);
    Transaction makeATransaction(TransactionDTO transactionDTO);

}
