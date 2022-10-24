package com.example.BankingApp.controllers.impl.account;

import com.example.BankingApp.controllers.dto.CheckingDTO;
import com.example.BankingApp.controllers.interfaces.account.CheckingControllerInterface;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.Checking;
import com.example.BankingApp.repositories.account.CheckingRepository;
import com.example.BankingApp.services.impl.account.AccountService;
import com.example.BankingApp.services.impl.account.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class CheckingController implements CheckingControllerInterface {
    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private CheckingService checkingService;

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> getAllCheckingAccounts() {
        return checkingRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getCheckingAccount(@PathVariable("id") Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createNewAccount(@RequestBody @Valid CheckingDTO checkingDTO) {
        return checkingService.createNewAccount(checkingDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        checkingRepository.deleteById(id);
    }
}
