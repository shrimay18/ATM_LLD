package components;

import bank.Bank;

import java.util.Scanner;

public class PinInput {
    public boolean enterPin(Scanner sc, Bank bank) {
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        return bank.validatePin(pin);
    }

    public void changePin(Scanner sc, Bank bank) {
        System.out.print("Enter new PIN: ");
        int newPin = sc.nextInt();
        bank.changePin(newPin);
        System.out.println("PIN changed successfully.");
    }
}
