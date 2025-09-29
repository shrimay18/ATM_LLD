package components;

import bank.Account;

public class Printer {
    public void printTransaction(String msg, Account account) {
        System.out.println("---- Transaction Receipt ----");
        System.out.println(msg);
        System.out.println("Balance: " + account.getBalance());
        System.out.println("-----------------------------");
    }

    public void printMiniStatement(Account account) {
        System.out.println("---- Mini Statement ----");
        account.printTransactions();
        System.out.println("-------------------------");
    }
}
