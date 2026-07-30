package com.banco.billetera.controller;

import com.banco.billetera.dto.TransferRequest;
import com.banco.billetera.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest request){
        accountService.transferMoney(
                request.getSourceAccountId(),
                request.getDestinationAccountId(),
                request.getAmount()
        );
    }
}
