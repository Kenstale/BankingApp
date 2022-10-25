package com.example.BankingApp.controllers.dto;

import com.example.BankingApp.enums.TransactionType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ThirdPartyTransactionDTO {
    @NotNull(message = "An amount must be specified")
    @Positive(message = "The amount must be positive")
    private BigDecimal amount;

    @NotNull (message = "An Account id must be specified")
    private Long accountId;

    @NotNull (message = "The account's secret key is required")
    private String secretKey;

    @NotNull (message = "Please, specify Send or Receive for the type of transaction")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;


}
