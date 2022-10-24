package com.example.BankingApp.controllers.impl.account;

import com.example.BankingApp.controllers.dto.BalanceDTO;
import com.example.BankingApp.controllers.dto.StatusDTO;
import com.example.BankingApp.controllers.interfaces.account.AccountControllerInterface;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.repositories.account.AccountRepository;
import com.example.BankingApp.services.impl.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.AttributeOverrides;
import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController implements AccountControllerInterface {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccount(@PathVariable("id") Long id) {
        return accountService.getAccount(id);
    }

    @GetMapping("/myAccount")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccountHolderAccounts(@AuthenticationPrincipal UserDetails userDetails) {
        return accountService.getAllAccountHolderAccounts(userDetails.getUsername());
    }

    @PatchMapping("/accounts/balance/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBalance(@PathVariable ("id") Long id, @RequestBody @Valid BalanceDTO balanceDTO){
        accountService.updateAccountBalance(id, balanceDTO);
    }

    @PatchMapping("/accounts/status/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void changeStatus(@PathVariable ("id") Long id, @RequestBody StatusDTO statusDTO){
        accountService.changeStatus(id, statusDTO);
    }

    @DeleteMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable("id") Long id){
        accountRepository.deleteById(id);
    }
}
