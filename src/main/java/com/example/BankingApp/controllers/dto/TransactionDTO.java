package com.example.BankingApp.controllers.dto;

import com.example.BankingApp.embedable.Money;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TransactionDTO {
    @NotNull(message = "An account id is required")
    private Long provenanceAccountId;

    @NotNull(message = "An account id is required")
    private Long destinationAccountId;

    @NotNull(message = "A name must be provided")
    @NotBlank(message = "A name must be provided")
    private String destinationAccountHolderName;

    private Money transaction;

    private LocalDateTime transactionDate;

    public TransactionDTO(Long provenanceAccountId, Long destinationAccountId, String destinationAccountHolderName,
                          Money transaction, LocalDateTime transactionDate) {
        setProvenanceAccountId(provenanceAccountId);
        setDestinationAccountId(destinationAccountId);
        setDestinationAccountHolderName(destinationAccountHolderName);
        setTransaction(transaction);
        setTransactionDate(transactionDate);
    }

    public TransactionDTO(Long provenanceAccountId, Long destinationAccountId, String destinationAccountHolderName, Money transaction) {
        setProvenanceAccountId(provenanceAccountId);
        setDestinationAccountId(destinationAccountId);
        setDestinationAccountHolderName(destinationAccountHolderName);
        setTransaction(transaction);
        setTransactionDate(LocalDateTime.now());
    }

    public Long getProvenanceAccountId() {
        return provenanceAccountId;
    }

    public void setProvenanceAccountId(Long provenanceAccountId) {
        this.provenanceAccountId = provenanceAccountId;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public String getDestinationAccountHolderName() {
        return destinationAccountHolderName;
    }

    public void setDestinationAccountHolderName(String destinationAccountHolderName) {
        this.destinationAccountHolderName = destinationAccountHolderName;
    }

    public Money getTransaction() {
        return transaction;
    }

    public void setTransaction(Money transaction) {
        this.transaction = transaction;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
