package com.banco.billetera.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public UUID getId(){ return id; }

    public void setID(UUID id){ this.id = id; }

    @Column(nullable = false)
    private UUID sourceAccountId;

    public UUID getSourceAccountId(){ return sourceAccountId; }

    public void setSourceAccountId(UUID sourceAccountId){ this.sourceAccountId = sourceAccountId; }

    @Column(nullable = false)
    private UUID destinationAccountId;

    public UUID getDestinationAccountId(){return destinationAccountId; }

    public void setDestinationAccountId(UUID destinationAccountId){ this.destinationAccountId = destinationAccountId; }

    @Column(nullable = false)
    private BigDecimal amount;

    public BigDecimal getAmount(){ return amount; }

    public void setAmount(BigDecimal amount){ this.amount = amount; }

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt(){ return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt){ this.createdAt = createdAt; }
}