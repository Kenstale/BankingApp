package com.example.BankingApp.models.users;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "third_party")
public class ThirdPartyUser {

    //There must be a way for third-party users to receive and send money to other accounts.
    //Third-party users must be added to the database by an admin.
   // In order to receive and send money, Third-Party Users must provide their hashed key in the header of the HTTP request.
    // They also must provide the amount, the Account id and the account secret key.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hashedKey;

    @NotNull(message = "A name must be provided")
    @NotBlank(message = "A name must be provided")
    private String name;


    // Constructor
    public ThirdPartyUser() {
    }
    public ThirdPartyUser(String name, String hashedKey) {
        setName(name);
        setHashedKey(hashedKey);
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public void setName(String name) {
        this.name = name;
    }


}
