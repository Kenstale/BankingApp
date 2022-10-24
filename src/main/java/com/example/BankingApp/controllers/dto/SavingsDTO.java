package com.example.BankingApp.controllers.dto;

import com.example.BankingApp.embedable.Constants;
import com.example.BankingApp.embedable.Money;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class SavingsDTO {
    @NotNull(message = "A specific balance and its currency are required")
    private Money balance;

    @NotNull(message = "An account holder id is required")
    private Long primaryOwner;

    private Long secondaryOwner;

    private Money minimumBalance;

    @NotNull(message = "A secret key is required")
    @NotBlank(message = "A secret key is required")
    private String secretKey;

    @DecimalMax(value = "0.5", message = "The interest rate cannot be greater than 0.5")
    @Positive(message = "Interest rate must be a positive number")
    private BigDecimal interestRate;

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Long getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(Long primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public Long getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(Long secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

// Constructor

    // interestRate by default
    public SavingsDTO(Money balance, Long primaryOwner, Long secondaryOwner, Money minimumBalance, String secretKey) {
        setBalance(balance);
        setPrimaryOwner(primaryOwner);
        setSecondaryOwner(secondaryOwner);
        setFirstMinimumBalance(minimumBalance);
        setSecretKey(secretKey);
        setInterestRate(Constants.SAVINGS_ACCOUNT_DEFAULT_INTEREST_RATE);
    }

    // minimumBalance by default
    public SavingsDTO(Money balance, Long primaryOwner, Long secondaryOwner, String secretKey, BigDecimal interestRate) {
        setBalance(balance);
        setPrimaryOwner(primaryOwner);
        setSecondaryOwner(secondaryOwner);
        setMinimumBalance(new Money(Constants.SAVINGS_ACCOUNT_DEFAULT_MIN_BALANCE));
        setSecretKey(secretKey);
        setInterestRate(interestRate);
    }

    // interestRate and minimumBalance by default
    public SavingsDTO(Money balance, Long primaryOwner, Long secondaryOwner, String secretKey) {
        setBalance(balance);
        setPrimaryOwner(primaryOwner);
        setSecondaryOwner(secondaryOwner);
        setMinimumBalance(new Money(Constants.SAVINGS_ACCOUNT_DEFAULT_INTEREST_RATE));
        setSecretKey(secretKey);
        setInterestRate(Constants.SAVINGS_ACCOUNT_DEFAULT_INTEREST_RATE);
    }


    public void setFirstMinimumBalance(Money minimumBalance) {
        if(minimumBalance.getAmount().compareTo(new BigDecimal(100)) >= 0 || minimumBalance.getAmount().compareTo(new BigDecimal(1000)) <= 0) {
            this.minimumBalance = minimumBalance;
        } else {
            System.out.println("The minimum balance cannot be lower than 100");
        }
    }
}
