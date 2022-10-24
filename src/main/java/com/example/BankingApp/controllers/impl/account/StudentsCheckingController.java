package com.example.BankingApp.controllers.impl.account;

import com.example.BankingApp.controllers.interfaces.account.StudentCheckingControllerInterface;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.StudentChecking;
import com.example.BankingApp.repositories.account.StudentCheckingRepository;
import com.example.BankingApp.services.impl.account.AccountService;
import com.example.BankingApp.services.impl.account.CheckingService;
import com.example.BankingApp.services.impl.interfaces.account.AccountServiceInterface;
import com.example.BankingApp.services.impl.interfaces.account.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentsCheckingController implements StudentCheckingControllerInterface {
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private CheckingServiceInterface checkingService;

    @Autowired
    private AccountServiceInterface accountService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> getAllStudentCheckingAccounts() {
        return studentCheckingRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getStudentCheckingAccount(@PathVariable("id") Long id) {
        return accountService.getAccount(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        studentCheckingRepository.deleteById(id);
    }
}
