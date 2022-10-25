package com.example.BankingApp.controllers.impl.user;

import com.example.BankingApp.controllers.dto.ThirdPartyDTO;
import com.example.BankingApp.controllers.dto.ThirdPartyTransactionDTO;
import com.example.BankingApp.controllers.interfaces.user.IThirdPartyController;
import com.example.BankingApp.models.users.ThirdPartyUser;
import com.example.BankingApp.repositories.user.ThirdPartyRepository;
import com.example.BankingApp.services.impl.interfaces.user.IThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ThirdPartyController implements IThirdPartyController {

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private IThirdPartyService thirdPartyService;

    @GetMapping("/thirdParty")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdPartyUser> getAllThirdParties() {
        return thirdPartyRepository.findAll();
    }

    @GetMapping("/thirdParty/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ThirdPartyUser> getThirdParty(@PathVariable("id") Long id) {
        return thirdPartyRepository.findById(id);
    }

    @PostMapping("/thirdParty")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdPartyUser addThirdParty(@RequestBody @Valid ThirdPartyDTO thirdPartyDTO) {
        return thirdPartyService.addThirdParty(thirdPartyDTO);
    }

    @PostMapping("/TP/transaction/{hashedKey}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ThirdPartyTransactionDTO makeATransaction(@PathVariable("hashedKey") String hashedKey,
                                                     @RequestBody @Valid ThirdPartyTransactionDTO transactionDTO) {
        return thirdPartyService.makeATransaction(transactionDTO);
    }

    @DeleteMapping("/thirdParty/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        thirdPartyRepository.deleteById(id);
    }

}
