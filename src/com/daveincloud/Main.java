package com.daveincloud;

import com.daveincloud.bankapp.AccountManager;

import java.util.Scanner;

//byte = 127
//short = 32k
//int = 2B
public class Main {
    public static void main(String[] args){
        //create scanner and choice ints
        Scanner scanner = new Scanner(System.in);
        int choice;

        while(true) {
            //first screen
            System.out.println("Choose an app to test out!\n--------------------");
            //add more apps here
            System.out.println("1. Bank Simulation App");
            System.out.println("-------------------- \nChoose an option...");
            //  handle exceptions
            try{
                choice = Integer.parseInt(scanner.nextLine());
                //enter second screen and create screen sub choice
                if (choice == 1) {
                    AccountManager accountManager = new AccountManager(); //account manager called here so that manager persists

                    while (true) {
                        int subChoice;
                        System.out.println("--------------------\nWelcome to the account Management Dashboard!!");
                        System.out.println("--------------------\nClick 1 to Create a new account");
                        System.out.println("Click 2 to List all accounts");
                        System.out.println("--------------------\nYour Choice: ");

                        try {
                            subChoice = Integer.parseInt(scanner.nextLine());

                            switch (subChoice) {
                                case 1:
                                    System.out.println("Enter an account name:");
                                    accountManager.createAccount(scanner.nextLine());
                                    break;
                                case 2:
                                    accountManager.listAccounts();
                                    break;
                                default:
                                    System.out.println("Enter a valid option...");
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Numbers only!!");
                        }
                    }
                } else {
                    System.out.println("invalid option, try again");
                }
            }catch (NumberFormatException e){
                System.out.println("Numbers only!!");

            }

        }
    }
}
