package com.example.BankingApp.controllers.interfaces;

import com.example.BankingApp.controllers.dto.TransactionDTO;
import com.example.BankingApp.models.operation.Transaction;

import java.util.List;
import java.util.Optional;

public interface ITransactionController {
    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransaction(Long id);
    Transaction createTransaction(TransactionDTO transactionDTO);
}
