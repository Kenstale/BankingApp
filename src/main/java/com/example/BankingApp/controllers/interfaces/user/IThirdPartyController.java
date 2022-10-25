package com.example.BankingApp.controllers.interfaces.user;

import com.example.BankingApp.controllers.dto.ThirdPartyDTO;
import com.example.BankingApp.controllers.dto.ThirdPartyTransactionDTO;
import com.example.BankingApp.models.users.ThirdPartyUser;

import java.util.List;
import java.util.Optional;

public interface IThirdPartyController {
    List<ThirdPartyUser> getAllThirdParties();
    Optional<ThirdPartyUser> getThirdParty(Long id);
    ThirdPartyUser addThirdParty(ThirdPartyDTO thirdPartyDTO);
    ThirdPartyTransactionDTO makeATransaction(String hashedKey, ThirdPartyTransactionDTO transactionDTO);
    void delete(Long id);
}
