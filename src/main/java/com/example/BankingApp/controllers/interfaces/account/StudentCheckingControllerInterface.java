package com.example.BankingApp.controllers.interfaces.account;

import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.StudentChecking;

import java.util.List;

public interface StudentCheckingControllerInterface {

    List<StudentChecking> getAllStudentCheckingAccounts();
    Account getStudentCheckingAccount(Long id);
    void delete( Long id);

}
