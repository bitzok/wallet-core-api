package com.banco.billetera.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class TransferRequest {
    private UUID sourceAccountId;
    public UUID getSourceAccountId() { return sourceAccountId; }
    public void setSourceAccountId(UUID sourceAccountId) { this.sourceAccountId = sourceAccountId; }

    private UUID destinationAccountId;
    public UUID getDestinationAccountId() { return destinationAccountId; }
    public void setDestinationAccountId(UUID destinatarioAccountId) { this.destinationAccountId = destinatarioAccountId; }

    private BigDecimal amount;
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
