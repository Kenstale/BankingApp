package com.example.BankingApp.models.Accounts;


import javax.validation.constraints.NotNull;

import com.example.BankingApp.embedable.Money;
import com.example.BankingApp.models.users.AccountHolder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@PrimaryKeyJoinColumn(name = "id")
@DynamicUpdate
@Table(name = "checking_account")
public class Checking extends Account {



    @NotNull(message = "Secret key require")
    @NotNull(message = "Secret key required")
    @Column(name = "checking_account")
    private String secretKey;
    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    private AccountHolder PrimaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolder SecondaryOwner;
    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_amount")),
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_currency"))

    })
    private Money minimumBalance;
    private double penaltyFee;
    private double monthlyMaintenanceFee;


    public Checking() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public AccountHolder getPrimaryOwner() {
        return PrimaryOwner;
    }

    @Override
    public void setPrimaryOwner(AccountHolder primaryOwner) {
        PrimaryOwner = primaryOwner;
    }

    @Override
    public AccountHolder getSecondaryOwner() {
        return SecondaryOwner;
    }

    @Override
    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        SecondaryOwner = secondaryOwner;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(double penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public double getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(double monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, AccountHolder primaryOwner1, AccountHolder secondaryOwner1, Money minimumBalance, double penaltyFee, double monthlyMaintenanceFee) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        PrimaryOwner = primaryOwner1;
        SecondaryOwner = secondaryOwner1;
        this.minimumBalance = minimumBalance;
        this.penaltyFee = penaltyFee;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
    //minimumBalance y monthlyMaintenanceFee son propiedades final
    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        setSecretKey(secretKey);
    }
}
