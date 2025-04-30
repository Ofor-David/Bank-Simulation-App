package com.daveincloud.bankapp;

import java.text.NumberFormat;
import java.util.Random;

public class Account {
    //account details
    double balance = 0;
    final long accountNo;
    final String accountName;

    NumberFormat formatter = NumberFormat.getCurrencyInstance();// formats numbers to currency format

    //constructor
    public Account(String accountName){
        this.accountName = accountName;
        //make unique
        this.accountNo = new Random().nextLong(1_000_000_000L,9_999_999_999L);
    }
    //view account details
    public void viewDetails(){
        System.out.println("Your Account Details:");
        System.out.println("\nAccount Name: "+ accountName);
        System.out.println("Account Number: "+ accountNo);
        System.out.println("Balance: "+ formatter.format(balance));
    }

    //deposit
    public void deposit(float amount){
        balance+=amount;
        System.out.println("successfully deposited " + formatter.format(amount));
    }
    //withdraw
    public void withdraw(float amount){
        balance-=amount;
        System.out.println("Successfully withdrawal of " + formatter.format(amount));
    }

    public String toString(){
        return accountName+": "+accountNo;
    }
}
