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
    //delete accounts
}
