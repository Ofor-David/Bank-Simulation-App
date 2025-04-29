package com.daveincloud;

public class Account {
    float balance = 0;
    //view balance
    void viewBalance(){
        System.out.println("account balance is: $"+balance);
    }

    //deposit
    void deposit(float amount){
        balance+=amount;
        System.out.println("succesfully deposited $" + amount);
    }
    //withdraw
    void withdraw(float amount){
        balance-=amount;
        System.out.println("Successfully withdrew $"+amount);
    }
}
