package com.example.BankingApp.models.Accounts;

import com.example.BankingApp.embedable.Money;
import com.example.BankingApp.models.users.AccountHolder;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DynamicUpdate
@Table(name = "student_checking_account")
public class StudentChecking extends Account{

    private BigDecimal minimumBalance;
    private double monthlyMaintenanceFee;

    @NotNull(message = "A secret key is required")
    @NotBlank(message = "A secret key is required")
    @Column(name = "secret_key")
    private String secretKey;

    public StudentChecking() {
    }

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        setSecretKey(secretKey);
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
