package com.example.BankingApp.controllers.dto;

import javax.validation.constraints.NotNull;

public class ThirdPartyDTO {
    @NotNull(message = "A name is required")
    private String name;

    private String hashedKey;
}
