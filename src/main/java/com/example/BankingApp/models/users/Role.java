package com.example.BankingApp.models.users;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private User user;

    // Constructor

    public Role() {
    }

    public Role(String name, User user) {
        this.name = name;
        this.user = user;
    }

}
