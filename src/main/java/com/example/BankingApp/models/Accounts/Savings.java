package com.example.BankingApp.models.Accounts;

import com.example.BankingApp.embedable.Constants;
import com.example.BankingApp.embedable.Money;
import com.example.BankingApp.models.users.AccountHolder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DynamicUpdate
@Table(name = "savings_account")
public class Savings extends Checking{


    @NotNull(message = "Secret key require")
    @NotNull(message = "Secret key required")
    @Column(name = "checking_account")
    private String secretKey;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_amount")),
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_currency"))

    })
    private Money minimumBalance;

    @Column(name = "last_interest_application_date")
    private LocalDate lastInterestApplicationDate = getCreationDate();

    @DecimalMax(value = "0.5", message = "The interest rate cannot be greater than 0.5")
    @Positive(message = "Interest rate must be a positive number")
    @Column(name = "interest_rate", columnDefinition = "DECIMAL(4,4)")
    private BigDecimal interestRate;

    public Savings() {
    }

    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                   Money minimumBalance, String secretKey, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        setFirstMinimumBalance(minimumBalance);
        setSecretKey(secretKey);
        setInterestRate(interestRate);
    }
    // interestRate by default
    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                   Money minimumBalance, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        setFirstMinimumBalance(minimumBalance);
        setSecretKey(secretKey);
        setInterestRate(Constants.SAVINGS_ACCOUNT_DEFAULT_INTEREST_RATE);
    }

    // minimumBalance by default
    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                   String secretKey, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        setMinimumBalance(new Money(Constants.SAVINGS_ACCOUNT_DEFAULT_MIN_BALANCE));
        setSecretKey(secretKey);
        setInterestRate(interestRate);
    }

    // interestRate and minimumBalance by default
    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        setMinimumBalance(new Money(Constants.SAVINGS_ACCOUNT_DEFAULT_MIN_BALANCE));
        setSecretKey(secretKey);
        setInterestRate(Constants.SAVINGS_ACCOUNT_DEFAULT_INTEREST_RATE);
    }

    // Setters


    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void setFirstMinimumBalance(Money minimumBalance) {
        if(minimumBalance.getAmount().compareTo(new BigDecimal(100)) >= 0 || minimumBalance.getAmount().compareTo(new BigDecimal(1000)) <= 0) {
            this.minimumBalance = minimumBalance;
        } else {
            System.out.println("The minimum balance cannot be lower than 100");
        }
    }
}

