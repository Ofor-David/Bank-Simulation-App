package com.daveincloud.bankapp;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class Account {
    //account details
    private double accountBal;
    private long accountNo;
    private String accountName;
    Scanner scanner = new Scanner(System.in);

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
    public String viewBalance() {
        return formatter.format(getBalance());
    }

    //deposit
    public void deposit(double amount){
        accountBal+=amount;
        System.out.println("successfully deposited " + formatter.format(amount));
        System.out.println("New Balance: "+formatter.format(getBalance()));
    }
    //withdraw
    public void withdraw(){
        while (true){
            System.out.println("Current balance: "+ viewBalance());
            System.out.println("Enter amount less than balance: ");
            try{
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount<= getBalance()){
                    accountBal-=amount;
                    System.out.println(formatter.format(amount) + " Withdrawn succesfully.");
                    System.out.println("New Balance: "+formatter.format(getBalance()));
                    break;
                }else{
                    System.out.println("Enter amount greater then balance!! ");
                }

            }catch (NumberFormatException e){
                System.out.println("Numbers only!!");
            }

        }
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
