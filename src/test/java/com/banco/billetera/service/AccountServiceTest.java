package com.banco.billetera.service;

import com.banco.billetera.entity.Account;
import com.banco.billetera.entity.Transaction;
import com.banco.billetera.repository.AccountRepository;
import com.banco.billetera.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountService accountService;

    @Test
    public void transferCheck(){
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Account account1 = new Account();
        account1.setId(id1);
        account1.setDocumentNumber("12345678");
        account1.setBalance(new BigDecimal("1000.00"));

        Account account2 = new Account();
        account2.setId(id2);
        account2.setDocumentNumber("87654321");
        account2.setBalance(new BigDecimal("600.00"));

        when(accountRepository.findById(id1)).thenReturn(Optional.of(account1));
        when(accountRepository.findById(id2)).thenReturn(Optional.of(account2));

        BigDecimal transferAmount = new BigDecimal("200.00");

        accountService.transferMoney(id1,id2,transferAmount);

        assertEquals(new BigDecimal("800.00"),account1.getBalance());
        assertEquals(new BigDecimal("800.00"),account2.getBalance());
    }

    @Test
    public void transferCheckNotFunds(){
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Account account1 = new Account();
        account1.setId(id1);
        account1.setDocumentNumber("12345678");
        account1.setBalance(new BigDecimal("300.00"));

        Account account2 = new Account();
        account2.setId(id2);
        account2.setDocumentNumber("87654321");
        account2.setBalance(new BigDecimal("600.00"));

        when(accountRepository.findById(id1)).thenReturn(Optional.of(account1));
        when(accountRepository.findById(id2)).thenReturn(Optional.of(account2));

        BigDecimal transferAmount = new BigDecimal("2000.00");

        assertThrows(IllegalArgumentException.class, () -> {
            accountService.transferMoney(id1,id2,transferAmount);
        });
    }

}
