package atm;

import bank.Account;

import java.util.Scanner;

public class TransactionState implements ATMState {
    private ATM atm;
    private String type;

    public TransactionState(ATM atm, String type) {
        this.atm = atm;
        this.type = type;
    }

    @Override
    public void handle() {
        Scanner sc = atm.getScanner();
        Account acc = atm.getBank().getActiveAccount();

        if (type.equals("withdraw")) {
            System.out.print("Enter amount to withdraw: ");
            int amt = sc.nextInt();
            if (amt % 100 != 0) {
                System.out.println("Invalid amount! ATM supports only multiples of 100.");
            } else if (acc.withdraw(amt)) {
                atm.getCashDispenser().dispenseCash(amt);
                atm.getPrinter().printTransaction("Withdrawn: " + amt, acc);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else if (type.equals("deposit")) {
            System.out.print("Enter amount to deposit: ");
            int amt = sc.nextInt();
            atm.getDepositSlot().deposit(amt, acc);
            atm.getPrinter().printTransaction("Deposited: " + amt, acc);
        }

        atm.setState(new PinEnteredState(atm));
    }
}
