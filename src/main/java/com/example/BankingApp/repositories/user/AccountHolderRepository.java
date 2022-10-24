package com.example.BankingApp.repositories.user;

import com.example.BankingApp.models.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

    Optional<AccountHolder> findByName(String name);

    Optional<AccountHolder> findByUsername(String username);
}
