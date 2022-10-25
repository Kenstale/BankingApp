package com.example.BankingApp.controllers.dto;

import com.example.BankingApp.enums.AccountStatus;

public class StatusDTO {

    private AccountStatus accountStatus;

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
