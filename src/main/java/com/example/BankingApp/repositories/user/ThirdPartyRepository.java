package com.example.BankingApp.repositories.user;

import com.example.BankingApp.models.users.ThirdPartyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdPartyUser, Long> {
}
