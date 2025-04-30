package com.daveincloud.bankapp;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    //all accounts
    ArrayList<Account> accounts = new ArrayList<>();
    //Scanner scanner = new Scanner(System.in);
    //int choice;

    //list accounts
    public void listAccounts() {
        System.out.println("------------------");
        if (accounts.isEmpty()){
            System.out.println("No accounts created yet, create some!!");
        }else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
        System.out.println("-------------------\nPress Anything...");
        new Scanner(System.in).nextLine();
    }

    //create accounts
    public void createAccount(String accountName) {
        System.out.println("-------------------");
        Account account = new Account(accountName);
        accounts.add(account);
        System.out.println("Account Created");
        System.out.println("Press Anything...\n-------------------");
        new Scanner(System.in).nextLine();
    }
    //delete accounts
}
