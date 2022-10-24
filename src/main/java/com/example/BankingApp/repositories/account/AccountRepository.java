package com.example.BankingApp.repositories.account;

import com.example.BankingApp.models.Accounts.Account;
import com.example.BankingApp.models.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByPrimaryOwnerId(Long id);

    List<Account> findByPrimaryOwner(AccountHolder accountHolder);

    List<Account> findBySecondaryOwner(AccountHolder accountHolder);
}
