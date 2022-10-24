package com.example.BankingApp.models.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "A name must be provided")
    @NotBlank(message = "A name must be provided")
    private String name;
    @NotNull(message = "A username must be provided")
    @NotBlank(message = "A username must be provided")
    private String username;

    @NotNull(message = "A password must be provided")
    @NotBlank(message = "A password must be provided")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> role;


    //Constructor

    protected User() {
    }

    public User(String name, String username, String password) {
        setName(name);
        setUsername(username);
        setPassword(password);
    }

 public void setName(String name) {
  this.name = name;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public void setPassword(String password) {
  this.password = password;
 }
}
