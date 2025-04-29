package com.daveincloud;

import com.daveincloud.bankapp.AccountManager;

import java.util.Scanner;

//byte = 127
//short = 32k
//int = 2B
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true) {
            System.out.println("Choose an app to test out!");
            System.out.println("1. Bank Simulation App");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                int subChoice;
                AccountManager accountManager = new AccountManager();
                while(true){
                System.out.println("Welcome to the account Management Dashboard!!");
                System.out.println("Click 1 to List all accounts");
                System.out.println("Click 2 to Create a new account");
                System.out.println("Your Choice: ");
                subChoice = Integer.parseInt(scanner.nextLine());

                    switch (subChoice){
                        case 1:
                            accountManager.listAccounts();
                            break;
                        case 2:
                            System.out.println("Enter new account name: ");
                            accountManager.createAccount(scanner.nextLine());
                            break;
                    }

                }
            }
        }



    }
}
