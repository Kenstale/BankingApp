package com.example.BankingApp.models.Accounts;

import com.example.BankingApp.embedable.Constants;
import com.example.BankingApp.embedable.Money;
import com.example.BankingApp.models.users.AccountHolder;

import java.math.BigDecimal;
import java.util.Date;

public class CreditCard extends Account{

    private Money balance;
    private AccountHolder PrimaryOwner;
    private AccountHolder SecondaryOwner;
    private Money creditLimit;
    private double penaltyFee;
    private BigDecimal interestRate;

    @Override
    public Money getBalance() {
        return balance;
    }

    public CreditCard() {
    }

    @Override
    public AccountHolder getPrimaryOwner() {
        return PrimaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        PrimaryOwner = primaryOwner;
    }

    @Override
    public AccountHolder getSecondaryOwner() {
        return SecondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        SecondaryOwner = secondaryOwner;
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(double penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        setFirstCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    // interestRate set by default
    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money creditLimit) {
        super(balance, primaryOwner, secondaryOwner);
        setFirstCreditLimit(creditLimit);
        setInterestRate(Constants.CREDITCARD_DEFAULT_INTEREST_RATE);
    }

    // creditLimit set by default
    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        setCreditLimit(new Money(Constants.CREDITCARD_DEFAULT_CREDIT_LIMIT));
        setInterestRate(interestRate);
    }

    // interestRate and creditLimit set by default
    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
        setCreditLimit(new Money(Constants.CREDITCARD_DEFAULT_CREDIT_LIMIT));
        setInterestRate(Constants.CREDITCARD_DEFAULT_INTEREST_RATE);
    }

    // Setters

    public void setFirstCreditLimit(Money creditLimit) {
        if(creditLimit.getAmount().compareTo(new BigDecimal(100)) >= 0 || creditLimit.getAmount().compareTo(new BigDecimal(100000)) <= 0) {
            this.creditLimit = creditLimit;
        } else {
            System.out.println("The credit limit cannot be lower than 100 or greater than 100000");
        }
    }

}
