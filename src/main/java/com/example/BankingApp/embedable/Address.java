package com.example.BankingApp.embedable;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Address {

    @NotNull(message ="Provide a street")
    @NotBlank(message ="Provide a street")
    private String street;

    @NotNull(message ="Provide a buildingNumber")
    @NotBlank(message ="Provide a buildingNumber")
    private int buildingNumber;

    @NotNull(message ="Provide a city")
    @NotBlank(message ="Provide a city")
    private String city;

    @NotNull(message ="Provide a country")
    @NotBlank(message ="Provide a country")
    private String country;

    @NotNull(message ="Provide a zipCode")
    @NotBlank(message ="Provide a zipCode")
    private Integer zipCode;



}
