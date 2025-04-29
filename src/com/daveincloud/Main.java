package com.daveincloud;
//byte = 127
//short = 32k
//int = 2B
public class Main {
    public static void main(String[] args){
        Account account1 = new Account();
        account1.viewBalance();
        account1.deposit(500);
        account1.viewBalance();
        account1.withdraw(200);
        account1.viewBalance();
    }
}
