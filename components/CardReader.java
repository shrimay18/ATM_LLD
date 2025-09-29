package components;

import bank.Bank;

import java.util.Scanner;

public class CardReader {
    public boolean insertCard(Scanner sc, Bank bank) {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        return bank.authenticateAccount(accNum);
    }
}
