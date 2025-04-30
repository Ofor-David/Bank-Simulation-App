package com.daveincloud.bankapp;

import java.text.NumberFormat;
import java.util.Random;

public class Account {
    //account details
    private double accountBal;
    private long accountNo;
    private String accountName;

    NumberFormat formatter = NumberFormat.getCurrencyInstance();// formats numbers to currency format

    //constructor
    public Account(String accountName){
        setAccountName(accountName);
        setAccountNumber();
        setAccountBalance();
    }
    //view account details
    public void viewDetails(){
        System.out.println("Hello " + getAccountName() + ",");
        System.out.println("Account Number: "+ getAccountNo());
        System.out.println("Balance: "+ formatter.format(getBalance()));
    }

    //deposit
    public void deposit(double amount){
        accountBal+=amount;
        System.out.println("successfully deposited " + formatter.format(amount));
        System.out.println("New Balance: "+formatter.format(getBalance()));
    }
    //withdraw
    public void withdraw(double amount){
        accountBal-=amount;
        System.out.println(formatter.format(amount) + " Withdrawn succesfully.");
        System.out.println("New Balance: "+formatter.format(getBalance()));
    }

    //override default toString function with this
    public String toString(){
        return "Account Name: "+accountName+"\nAccount Number: "+accountNo+"\n";
    }

    //getters
    public String getAccountName(){
        return accountName;
    }
    public double getBalance(){
        return accountBal;
    }
    public long getAccountNo(){
        return accountNo;
    }

    //setters
    public void setAccountName(String accountNameToBe){
        this.accountName = accountNameToBe;
    }
    public void setAccountNumber(){
        //make unique
        this.accountNo = new Random().nextLong(1_000_000_000L,9_999_999_999L);
    }
    public void setAccountBalance(){
        this.accountBal = 0;
    }


}
