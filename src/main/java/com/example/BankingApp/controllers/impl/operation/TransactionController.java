package com.example.BankingApp.controllers.impl.operation;

import com.example.BankingApp.controllers.dto.TransactionDTO;
import com.example.BankingApp.models.operation.Transaction;
import com.example.BankingApp.repositories.operation.TransactionRepository;
import com.example.BankingApp.services.impl.interfaces.TransactionControllerInterface;
import com.example.BankingApp.services.impl.user.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController implements TransactionControllerInterface {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountHolderService accountHolderService;

    @GetMapping("/transaction")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("/transaction/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Transaction> getTransaction(@PathVariable("id") Long id) {
        return transactionRepository.findById(id);
    }

    @PostMapping("/newTransaction")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transaction createTransaction(@RequestBody @Valid TransactionDTO transactionDTO) {
        return accountHolderService.makeATransaction(transactionDTO);
    }
}
