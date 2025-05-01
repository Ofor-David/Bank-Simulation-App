package com.daveincloud.bankapp;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    Scanner scanner = new Scanner(System.in);
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
        scanner.nextLine(); //wait on user input
    }

    //create accounts
    public void createAccount(String accountName) {
        System.out.println("-------------------");

        //check if account already exits
        //instantiate new account
        Account account = new Account(accountName);
        accounts.add(account); //add to list of accounts
        System.out.println("Account Created");
        System.out.println("Press Anything...\n-------------------");
        new Scanner(System.in).nextLine(); //wait on user input
    }

    //login to account
    public void login(long accountNumber){
        boolean accountDeleted = false;
        int indexToRemove = -1; // index of account to remove on deletion

        //find account with matching account number
        if (accounts.isEmpty()) {
            //no accounts
            System.out.println("No accounts created yet, create some!!");
            System.out.println("Press Anything...");
            scanner.nextLine(); //press anything

        }else if(!accountExists(accountNumber)) { //account not found
            System.out.println("Account not found!\nPress Anything...");
            scanner.nextLine();
        }
        else{

            //call search account
            for (Account account : accounts) {
                if (accountNumber == account.getAccountNo()) {
                    while(!accountDeleted){
                        //display account screen
                        System.out.println("------------------------");
                        System.out.println("Welcome to your personal account dashboard!!");
                        System.out.println("------------------");
                        account.viewDetails();
                        System.out.println("------------------");

                        //show account options
                        System.out.println("Press 1 to deposit");
                        System.out.println("Press 2 to withdraw");
                        System.out.println("Press 3 to delete account");

                        try {
                            int choice = Integer.parseInt(scanner.nextLine());
                            switch (choice){
                                case 1:
                                    //deposit
                                    account.deposit();
                                    System.out.println("--------------------\nPress Anything...");
                                    scanner.nextLine();
                                    break;
                                case 2:
                                    //withdraw
                                    account.withdraw();
                                    System.out.println("--------------------\nPress Anything...");
                                    scanner.nextLine();
                                    break;
                                case 3:
                                    //set account to be deleted upon exit
                                    System.out.println("Request to delete account received!\nPress Anything...");
                                    scanner.nextLine();
                                    indexToRemove = accounts.indexOf(account); //returns index of current account
                                    accountDeleted = true;
                                    break;
                                default:
                                    System.out.println("Invalid option");
                            }
                        }catch (NumberFormatException e ){
                            System.out.println("Numbers only!!");
                        }
                    }
                }
            }
            //remove account after breaking from the loop
            if (indexToRemove>=0) { //prevents -int error
                accounts.remove(indexToRemove);
            }
        }
    }

    boolean accountExists(long accountNo){
        for (Account account : accounts){
            if (account.getAccountNo() == accountNo){
                return true;
            }
        }
        return false;
    }
}
