package com.example.BankingApp.repositories.account;

import com.example.BankingApp.models.Accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
