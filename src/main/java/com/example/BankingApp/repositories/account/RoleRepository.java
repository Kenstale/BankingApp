package com.example.BankingApp.repositories.account;

import com.example.BankingApp.models.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
