package com.example.BankingApp.controllers.impl.user;

import com.example.BankingApp.controllers.dto.AccountHolderDTO;
import com.example.BankingApp.controllers.interfaces.user.IUserController;
import com.example.BankingApp.models.users.AccountHolder;
import com.example.BankingApp.models.users.User;
import com.example.BankingApp.repositories.user.AccountHolderRepository;
import com.example.BankingApp.repositories.user.UserRepository;
import com.example.BankingApp.services.impl.interfaces.user.IAccountHolderService;
import com.example.BankingApp.services.impl.user.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IAccountHolderService accountHolderService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("id") Long id) {
        return accountHolderService.getUser(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }


}
