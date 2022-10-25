package com.example.BankingApp.controllers.impl.user;

import com.example.BankingApp.controllers.interfaces.user.IAdminController;
import com.example.BankingApp.models.users.Admin;
import com.example.BankingApp.models.users.User;
import com.example.BankingApp.repositories.user.AdminRepository;
import com.example.BankingApp.services.impl.interfaces.user.IAccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController implements IAdminController {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private IAccountHolderService accountHolderService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getAdmin(@PathVariable("id") Long id) {
        return accountHolderService.getUser(id);
    }
}
