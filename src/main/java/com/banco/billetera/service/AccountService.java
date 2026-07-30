package com.banco.billetera.service;

import com.banco.billetera.entity.Account;
import com.banco.billetera.entity.Transaction;
import com.banco.billetera.repository.AccountRepository;
import com.banco.billetera.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void transferMoney(UUID sourceAccountId, UUID destinationAccountId, BigDecimal amount){
        Account existSource = accountRepository.findById(sourceAccountId).orElseThrow(() -> new IllegalArgumentException("La cuenta origen no existe"));
        Account existDestination = accountRepository.findById(destinationAccountId).orElseThrow(() -> new IllegalArgumentException("La cuenta destino no existe"));

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }

        if (amount.compareTo(existSource.getBalance()) > 0){
            throw new IllegalArgumentException("Fondos insuficientes");
        }

        existSource.setBalance(existSource.getBalance().subtract(amount));
        existDestination.setBalance(existDestination.getBalance().add(amount));

        accountRepository.save(existSource);
        accountRepository.save(existDestination);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setSourceAccountId(sourceAccountId);
        transaction.setDestinationAccountId(destinationAccountId);

        transactionRepository.save(transaction);
    }
}
