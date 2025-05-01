package com.daveincloud.bankapp;

import java.text.NumberFormat;
import java.time.LocalDateTime;

public class Transaction {

    private final String type;
    private final Double amount;
    private final LocalDateTime timestamp;
    private final Account initiator;

    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Transaction(String type, Double amount, LocalDateTime timestamp, Account initiator){
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.initiator = initiator;
    }

    @Override
    public String toString(){
        return timestamp + " | " + type.toUpperCase() + " | " + formatter.format(amount);

    }

    public Account getInitiator(){
        return initiator;
    }

}
