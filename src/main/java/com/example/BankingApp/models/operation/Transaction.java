package com.example.BankingApp.models.operation;


import com.example.BankingApp.embedable.Money;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "provenance_account_id")
    private Long provenanceAccountId;

    @NotNull
    @Column(name = "destination_account_id")
    private Long destinationAccountId;

    @NotNull(message = "A name must be provided")
    @NotBlank(message = "A name must be provided")
    @Column(name = "destination_account_holder_name")
    private String destinationAccountHolderName;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "transaction_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "transaction_currency"))
    })
    private Money transaction;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;


    //Constructor

    public Transaction(Long provenanceAccountId, Long destinationAccountId, String destinationAccountHolderName,
                       Money transaction) {
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
