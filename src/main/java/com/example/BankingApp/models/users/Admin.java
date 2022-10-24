package com.example.BankingApp.models.users;

import javax.persistence.Entity;

@Entity
public class Admin extends User{

    //Admins should be able to access the balance for any account and to modify it.

    public Admin() {
    }

    public Admin(String name, String username, String password) {
        super(name, username, password);
    }

}
