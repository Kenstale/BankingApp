package com.example.BankingApp.controllers.dto;

import com.example.BankingApp.embedable.Address;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AccountHolderDTO {
    @NotNull(message = "A name must be provided")
    @NotBlank(message = "A name must be provided")
    private String name;

    @NotNull(message = "A username must be provided")
    @NotBlank(message = "A username must be provided")
    private String username;

    @NotNull(message = "A password must be provided")
    @NotBlank(message = "A password must be provided")
    private String password;

    @NotNull(message = "A date of birth is required")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull(message = "A primary address must be provided")
    private Address primaryAddress;

    private Address mailingAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
// Constructor

    // mailing address is null
    public AccountHolderDTO(String name, String username, String password, LocalDate birthDate, Address primaryAddress) {
        setName(name);
        setUsername(username);
        setPassword(password);
        setBirthDate(birthDate);
        setPrimaryAddress(primaryAddress);
    }
}
