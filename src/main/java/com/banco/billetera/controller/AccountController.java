package com.banco.billetera.controller;

import com.banco.billetera.dto.AccountResponse;
import com.banco.billetera.dto.TransferRequest;
import com.banco.billetera.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable UUID id){
        AccountResponse accountResponse= accountService.getAccount(id);
        return accountResponse;
    }
}
