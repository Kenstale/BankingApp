package com.example.BankingApp.controllers.dto;

import com.example.BankingApp.embedable.Money;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CheckingDTO {
    @NotNull(message = "A specific balance and its currency are required")
    private Money balance;

    @NotNull(message = "An account holder id is required")
    private Long primaryOwner;

    private Long secondaryOwner;

    @NotNull(message = "A secret key is required")
    @NotBlank(message = "A secret key is required")
    private String secretKey;
}
