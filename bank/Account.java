package bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private int pin;
    private int balance;
    private List<Transaction> transactions;

    public Account(int accountNumber, int pin, int balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public int getBalance() { return balance; }
    public int getPin() { return pin; }
    public void setPin(int pin) { this.pin = pin; }
}
