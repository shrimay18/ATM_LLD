package components;

import bank.Account;

public class DepositSlot {
    public void deposit(int amt, Account account) {
        account.deposit(amt);
        System.out.println("Successfully deposited: " + amt);
    }
}
