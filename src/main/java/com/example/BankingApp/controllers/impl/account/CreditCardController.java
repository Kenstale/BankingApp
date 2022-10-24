package com.example.BankingApp.controllers.impl.account;

import com.example.BankingApp.controllers.dto.CCardDTO;
import com.example.BankingApp.controllers.interfaces.account.CreditCardControllerInterface;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.CreditCard;
import com.example.BankingApp.repositories.user.CreditCardRepository;
import com.example.BankingApp.services.impl.account.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditCardController implements CreditCardControllerInterface {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getAllCreditCardAccount() {
        return creditCardRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCard getCreditCardAccount(@PathVariable("id") Long id) {
        return creditCardService.getCreditCardAccount(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createNewAccount(@RequestBody @Valid CCardDTO creditCardDTO) {
        return creditCardService.createNewAccount(creditCardDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        creditCardRepository.deleteById(id);
    }
}
