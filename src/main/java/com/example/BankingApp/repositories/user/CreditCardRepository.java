package com.example.BankingApp.repositories.user;

import com.example.BankingApp.models.Accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
