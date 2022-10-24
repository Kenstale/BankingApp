package com.example.BankingApp.controllers.impl.account;

import com.example.BankingApp.controllers.dto.SavingsDTO;
import com.example.BankingApp.controllers.interfaces.account.SavingsControllerInterface;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.Savings;
import com.example.BankingApp.repositories.account.SavingsRepository;
import com.example.BankingApp.services.impl.account.SavingsService;
import com.example.BankingApp.services.impl.interfaces.account.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class SavingsController implements SavingsControllerInterface {
    @Autowired
    private SavingsRepository savingsRepository;

    @Autowired
    private SavingsServiceInterface savingsService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Savings> getAllSavingsAccounts() {
        return savingsRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Savings getSavingsAccount(@PathVariable("id") Long id) {
        return savingsService.getSavingsAccount(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createNewAccount(@RequestBody @Valid SavingsDTO savingsDTO) {
        return savingsService.createNewAccount(savingsDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        savingsRepository.deleteById(id);
    }

}
