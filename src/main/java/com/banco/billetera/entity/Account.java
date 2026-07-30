package com.banco.billetera.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    @Column(unique=true, nullable=false)
    private String documentNumber;

    public String getDocumentNumber() { return documentNumber; }

    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    @Column(nullable=false)
    private BigDecimal balance;

    public BigDecimal getBalance() { return balance; }

    public void setBalance(BigDecimal balance) { this.balance = balance; }

}
