package com.banco.billetera.service;

import com.banco.billetera.repository.AccountRepository;
import com.banco.billetera.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void transferMoney(UUID sourceAccountId, UUID destinationAccountId, BigDecimal amount){

    }
}
