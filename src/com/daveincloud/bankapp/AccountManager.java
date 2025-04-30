package com.daveincloud.bankapp;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    //all accounts
    ArrayList<Account> accounts = new ArrayList<>();

    //list accounts
    public void listAccounts() {
        System.out.println("------------------");

        if (accounts.isEmpty()){  //no accounts
            System.out.println("No accounts created yet, create some!!");
        }else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
        System.out.println("-------------------\nPress Anything...");
        new Scanner(System.in).nextLine(); //wait on user input
    }

    //create accounts
    public void createAccount(String accountName) {
        System.out.println("-------------------");
        //instantiate new account
        Account account = new Account(accountName);
        accounts.add(account); //add to list of accounts
        System.out.println("Account Created");
        System.out.println("Press Anything...\n-------------------");
        new Scanner(System.in).nextLine(); //wait on user input
    }

    //login to account
    public void login(int accountNumber){
        //find account with matching account number
        if (accounts.isEmpty()) {
            //no accounts
            System.out.println("No accounts created yet, create some!!");
            System.out.println("press anything");
            new Scanner(System.in).nextLine(); //press anything
        }else {
            for (Account account : accounts) {
                if (accountNumber == account.accountNo) {
                    //display account screen
                    System.out.println("------------------");
                    System.out.println("Hello " + accountNumber + ",");
                    System.out.println("Welcome to your personal account dashboard!!");
                    System.out.println("------------------");
                    //show account options
                    System.out.println("Press 1 to deposit");
                    System.out.println("Press 2 to withdraw");
                    System.out.println("Press 3 to delete account");
                    //Todo: System.out.println("Press 4 to view transaction history");

                    //Todo: account functionality
                }
            }
        }
    }

    //delete accounts
}
