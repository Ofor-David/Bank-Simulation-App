package com.daveincloud;

import java.util.Scanner;

//byte = 127
//short = 32k
//int = 2B
public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account name: ");
        Account account1 = new Account(scanner.nextLine());
        account1.viewDetails();

    }
}
