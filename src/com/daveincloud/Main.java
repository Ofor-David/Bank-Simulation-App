package com.daveincloud;

import com.daveincloud.bankapp.AccountManager;

import java.util.Scanner;

// byte = 127
// short = 32k
// int = 2B
public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int choice; // Used to switch between apps

        while(true) {
            // first screen
            System.out.println("Choose an app to test out!\n--------------------");

            // add more apps here
            System.out.println("1. Bank Simulation App");

            System.out.println("-------------------- \nChoose an option...");
            // handle inputs
            try{
                choice = Integer.parseInt(scanner.nextLine());

                //enter second screen
                if (choice == 1) {
                    AccountManager accountManager = new AccountManager(); //account manager called here so that manager persists

                    while (true) {
                        int subChoice; //subChoice for selecting options
                        System.out.println("--------------------\nWelcome to the account Management Dashboard!!--------------------");

                        //account manager options
                        System.out.println("Click 1 to Create a new account");
                        System.out.println("Click 2 to List all accounts");
                        System.out.println("Click 3 to log in to account using accountNo");
                        System.out.println("Click q to go back");
                        System.out.println("--------------------\nYour Choice: ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("q")){
                            break;
                        }else {
                            try { //validate user input
                                subChoice = Integer.parseInt(input);

                                switch (subChoice) {
                                    case 1:
                                        while (true) { //enforce valid account name
                                            System.out.println("Enter a full name at once or click q to cancel: ");
                                            String nameRegexExpression = "^[A-Z][a-z]+ [A-Z][a-z]+$";
                                            input = scanner.nextLine();
                                            if (input.equalsIgnoreCase("q")) {
                                                break;
                                            }else {
                                                if (input.matches(nameRegexExpression)) {
                                                    accountManager.createAccount(input);
                                                    break;
                                                } else {
                                                    System.out.println("Enter valid name!");
                                                    System.out.println("Both names must start with UpperCase");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        accountManager.listAccounts();
                                        break;
                                    case 3:
                                        //login to account
                                        while (true){
                                            System.out.println("enter account Number or click q to go back:");
                                            input = scanner.nextLine();
                                            if (input.equalsIgnoreCase("q")) {
                                                break;
                                            }else {
                                                try {
                                                    long accountNo = Long.parseLong(input);
                                                    accountManager.login(accountNo);
                                                    break;
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Numbers only!!");
                                                }
                                            }
                                        }
                                    default:
                                        System.out.println("Enter a valid option...");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Numbers only!!");
                            }
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
