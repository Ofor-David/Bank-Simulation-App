package com.daveincloud.bankapp;

import java.util.ArrayList;

public class TransactionList extends ArrayList<Transaction> {
    private Account owner;

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Account getOwner(){
        return owner;
    }
}
