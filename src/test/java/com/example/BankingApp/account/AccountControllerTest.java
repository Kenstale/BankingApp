package com.example.BankingApp.account;

import com.example.BankingApp.models.users.AccountHolder;
import com.example.BankingApp.repositories.account.AccountRepository;
import com.example.BankingApp.repositories.account.CheckingRepository;
import com.example.BankingApp.repositories.account.RoleRepository;
import com.example.BankingApp.repositories.user.AccountHolderRepository;
import com.example.BankingApp.repositories.user.AdminRepository;
import com.example.BankingApp.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AccountControllerTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    /*AccountHolder primaryOwner = new AccountHolder();
        primaryOwner.setName("Ander Cortés");
        primaryOwner.setBirthDate(LocalDate.of(1995, 12, 3));
        primaryOwner.setUsername("tvander");
        primaryOwner.setPassword("705P&WM8ls*v3ru");
        primaryOwner.setPrimaryAddress(new Address("Calle Aribabu 23, Barcelona", 08603));
        accountHolderRepository.save(primaryOwner);*/
}
