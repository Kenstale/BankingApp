package com.example.BankingApp.repositories.account;

import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentCheckingRepository extends JpaRepository<Account, Long> {


  



}
