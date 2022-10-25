package com.example.BankingApp.repositories.user;

import com.example.BankingApp.models.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
