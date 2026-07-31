package com.banco.billetera.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountResponse {
    private UUID account;
    private BigDecimal balance;

    public UUID getAccount() { return account; }
    public void setAccount(UUID account) { this.account = account; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public AccountResponse(UUID account, BigDecimal balance) {
        this.account = account;
        this.balance = balance;
    }
}
