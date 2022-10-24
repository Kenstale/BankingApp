package com.example.BankingApp.services.impl.account;

import com.example.BankingApp.controllers.dto.CheckingDTO;
import com.example.BankingApp.embedable.Money;
import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.Accounts.StudentChecking;
import com.example.BankingApp.models.users.AccountHolder;
import com.example.BankingApp.repositories.account.CheckingRepository;
import com.example.BankingApp.repositories.account.StudentCheckingRepository;
import com.example.BankingApp.repositories.user.AccountHolderRepository;
import com.example.BankingApp.services.impl.interfaces.account.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Service
public class CheckingService implements CheckingServiceInterface {

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public Account createNewAccount(@NotNull CheckingDTO checkingDTO) {

        // When creating a new Checking account, if the primaryOwner is less than 24, a StudentChecking account should be created
        if(LocalDate.now().getYear() -
                accountHolderRepository.findById(checkingDTO.getPrimaryOwner()).get().getBirthDate().getYear() < 24) {

            Money balance = checkingDTO.getBalance();
            AccountHolder accountHolder = accountHolderRepository.findById(checkingDTO.getPrimaryOwner()).get();
            AccountHolder secondaryOwner;
            String secretKey = checkingDTO.getSecretKey();

            // secondaryOwner is an optional property so it could be null
            if(checkingDTO.getSecondaryOwner() != null) {
                secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwner()).get();
            } else {
                secondaryOwner = null;
            }

            StudentChecking studentChecking = new StudentChecking(balance, accountHolder, secondaryOwner, secretKey);
            studentCheckingRepository.save(studentChecking);
            return studentChecking;

        } else {

            Money balance = checkingDTO.getBalance();
            AccountHolder accountHolder = accountHolderRepository.findById(checkingDTO.getPrimaryOwner()).get();
            AccountHolder secondaryOwner;
            String secretKey = checkingDTO.getSecretKey();

            // secondaryOwner is an optional property so it could be null
            if(checkingDTO.getSecondaryOwner() != null) {
                secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwner()).get();
            } else {
                secondaryOwner = null;
            }

            Checking checking = new Checking(balance, accountHolder, secondaryOwner, secretKey);
            checkingRepository.save(checking);
            return checking;
        }

    }
}
