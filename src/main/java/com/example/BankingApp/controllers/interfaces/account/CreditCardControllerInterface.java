package com.example.BankingApp.controllers.interfaces.account;

import com.example.BankingApp.controllers.dto.CCardDTO;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.CreditCard;

import java.util.List;

public interface CreditCardControllerInterface {

    List<CreditCard> getAllCreditCardAccount();
    CreditCard getCreditCardAccount(Long id);
    Account createNewAccount(CCardDTO creditCardDTO);
    void delete(Long id);
}
