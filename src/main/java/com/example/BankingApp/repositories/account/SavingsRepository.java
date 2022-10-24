package com.example.BankingApp.repositories.account;


import com.example.BankingApp.models.Accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
