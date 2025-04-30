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
            System.out.println("Choose an app to test out!");
            //add more apps here
            System.out.println("1. Bank Simulation App");
            //  handle exceptions
            if (!scanner.hasNextInt()){
                System.out.println("Numbers only!!");
            }else {
                choice = Integer.parseInt(scanner.nextLine());
                //enter second screen and create screen sub choice
                if (choice == 1) {
                    while (true) {
                        int subChoice;
                        AccountManager accountManager = new AccountManager();
                        System.out.println("Welcome to the account Management Dashboard!!");
                        System.out.println("Click 1 to Create a new account");
                        System.out.println("Click 2 to List all accounts");
                        System.out.println("Your Choice: ");
                        subChoice = Integer.parseInt(scanner.nextLine());

                        switch (subChoice) {
                            case 1:
                                System.out.println("Enter an account name");
                                accountManager.createAccount(scanner.nextLine());
                                break;
                            case 2:
                                accountManager.listAccounts();
                                break;
                            default:
                                System.out.println("Enter a valid option...");
                        }
                    }
                } else {
                    System.out.println("invalid option, try again");
                }
            }

        }
    }
}
