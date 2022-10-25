package com.example.BankingApp.controllers.impl.user;

import com.example.BankingApp.controllers.dto.AccountHolderDTO;
import com.example.BankingApp.controllers.interfaces.user.IAccountHolderController;
import com.example.BankingApp.models.users.AccountHolder;
import com.example.BankingApp.models.users.User;
import com.example.BankingApp.repositories.user.AccountHolderRepository;
import com.example.BankingApp.services.impl.user.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accountHolder")
public class AccountHolderController implements IAccountHolderController {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AccountHolderService accountHolderService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getAccountHolder(@PathVariable("id") Long id) {
        return accountHolderService.getUser(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolderDTO accountHolderDTO) {
        return accountHolderService.addAccountHolder(accountHolderDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        accountHolderRepository.deleteById(id);
    }
}
