package com.example.BankingApp.embedable;

import javax.persistence.Embeddable;
import java.math.BigDecimal;


@Embeddable
public class Constants {
    public static final BigDecimal  PENALTY_FEE = new BigDecimal(40.0);

    public static final BigDecimal  CREDITCARD_DEFAULT_INTEREST_RATE = new BigDecimal("0.2");

    public static final BigDecimal  CREDITCARD_DEFAULT_CREDIT_LIMIT = new BigDecimal(100);

    public static final BigDecimal  SAVINGS_ACCOUNT_DEFAULT_INTEREST_RATE = new BigDecimal("0.0025");

    public static final BigDecimal  SAVINGS_ACCOUNT_DEFAULT_MIN_BALANCE = new BigDecimal(1000);

    public static final BigDecimal  CHECKING_ACCOUNT_DEFAULT_MONTHLY_FEE = new BigDecimal("12.0");

    public static final BigDecimal  CHECKING_ACCOUNT_DEFAULT_MIN_BALANCE = new BigDecimal(250);

}
