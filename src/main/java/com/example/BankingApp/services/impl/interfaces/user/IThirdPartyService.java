package com.example.BankingApp.services.impl.interfaces.user;

import com.example.BankingApp.controllers.dto.ThirdPartyDTO;
import com.example.BankingApp.controllers.dto.ThirdPartyTransactionDTO;
import com.example.BankingApp.models.users.ThirdPartyUser;

public interface IThirdPartyService {
    ThirdPartyUser addThirdParty(ThirdPartyDTO thirdPartyDTO);
    ThirdPartyTransactionDTO makeATransaction(ThirdPartyTransactionDTO transactionDTO);

}
