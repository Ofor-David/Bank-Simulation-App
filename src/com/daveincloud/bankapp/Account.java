package com.daveincloud.bankapp;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Account {
    //account details
    private double accountBal;
    private long accountNo;
    private String accountName;

    private static ArrayList<Account> accounts = new ArrayList<>(); //list of generated accounts
    private TransactionList transactionList = new TransactionList();
    private static ArrayList<TransactionList> arrayOfTransactionLists = new ArrayList<>();

    private boolean hasDeposited = false;

    Scanner scanner = new Scanner(System.in);
    NumberFormat formatter = NumberFormat.getCurrencyInstance();// formats numbers to currency format

    //constructor
    public Account(String accountName){
            setAccountName(accountName);
            setAccountNumber();
            setAccountBalance();
            accounts.add(this);
            //this.hasDeposited = false;
            this.transactionList.setOwner(this);
            arrayOfTransactionLists.add(this.transactionList);
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
    public void deposit(){
        while (true) {
            System.out.println("Enter deposit amount:");
            try {
                double amount = Double.parseDouble(scanner.nextLine()); //must be a double
                if (amount > 0){
                    accountBal += amount;
                    System.out.println("successfully deposited " + formatter.format(amount));
                    System.out.println("New Balance: " + formatter.format(getBalance()));
                    //create new transaction
                    Transaction t = new  Transaction("deposit", amount, LocalDateTime.now(),this);
                    this.transactionList.add(t);

                    if (!this.hasDeposited) {
                        this.hasDeposited = true;
                    }
                    break;
                }else{
                    System.out.println("Must be greater than 0!");
                }

            }catch (NumberFormatException e){
                System.out.println("Numbers only!!");
            }
        }
    }
    //withdraw
    public void withdraw(){
        //Only allow withdrawal if already first deposited
        if (this.hasDeposited) {
            while (true) {
                System.out.println("Current balance: " + viewBalance());
                System.out.println("Enter amount to withdraw: ");
                try {
                    double amount = Double.parseDouble(scanner.nextLine());
                    if (amount <= getBalance() && amount >= 1) {
                        accountBal -= amount;
                        System.out.println(formatter.format(amount) + " Withdrawn successfully.");
                        System.out.println("New Balance: " + formatter.format(getBalance()));
                        //create new transaction
                        Transaction t = new Transaction("withdraw", amount, LocalDateTime.now(), this);
                        this.transactionList.add(t);
                        break;
                    } else if (amount < 1) { //refuse negative
                        System.out.println("Minimum withdrawal is: $1 or greater!!");
                    } else { //refuse
                        System.out.println("Enter amount less then balance!! ");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!!");
                }

            }
        }else {
            System.out.println("You have to deposit first!");
        }
    }

    @Override
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

    public ArrayList<Transaction> getTransactionList(){
        if (arrayOfTransactionLists.contains(this.transactionList)){
            return this.transactionList;
        }else{
            return new ArrayList<>();
        }
    }


    //setters
    public void setAccountName(String accountNameToBe){
        this.accountName = accountNameToBe;
    }
    public void setAccountNumber(){
        boolean isUnique = false;

        while (!isUnique){
            this.accountNo = new Random().nextLong(1_000_000_000L,9_999_999_999L);
            isUnique = true; //assume newly generated number is unique
            for (Account account : accounts){ //check if its actually unique
                if (this.accountNo == account.getAccountNo()) { //aleady exists
                    isUnique = false;
                    break;
                }
            }
        }
    }
    public void setAccountBalance(){
        this.accountBal = 0;
    }


}
