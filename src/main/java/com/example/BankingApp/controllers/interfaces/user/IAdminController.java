package com.example.BankingApp.controllers.interfaces.user;

import com.example.BankingApp.models.users.Admin;
import com.example.BankingApp.models.users.User;

import java.util.List;

public interface IAdminController {
    List<Admin> getAllAdmins();
    User getAdmin(Long id);
}
