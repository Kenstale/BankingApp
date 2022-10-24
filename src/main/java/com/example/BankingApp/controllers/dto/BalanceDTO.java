package com.example.BankingApp.controllers.dto;

import com.example.BankingApp.embedable.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class BalanceDTO {

    private Money balance;

    // Class constructor specifying amount and currency

    public BalanceDTO(BigDecimal amount, Currency currency) {
        setBalance(new Money(amount, currency, RoundingMode.HALF_EVEN));
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }
}
