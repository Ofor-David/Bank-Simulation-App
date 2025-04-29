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
        for (Account account : accounts) {
            System.out.println("Listing accounts");
            System.out.println(account.accountNo);
        }
    }

    //create accounts
    public void createAccount(String accountName) {
        System.out.println("creating accounts");
        Account account = new Account(accountName);
    }
    //delete accounts
}
