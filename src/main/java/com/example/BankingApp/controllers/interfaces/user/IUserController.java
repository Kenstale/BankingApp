package com.example.BankingApp.controllers.interfaces.user;

import com.example.BankingApp.models.users.User;

import java.util.List;

public interface IUserController {
    List<User> getAllUsers();
    User getUser(Long id);
    void delete(Long id);
}
