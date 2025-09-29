package bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();
    private Account activeAccount;

    public Bank() {
        // dummy accounts
        accounts.put(12345, new Account(12345, 1111, 5000));
        accounts.put(67890, new Account(67890, 2222, 10000));
    }

    public boolean authenticateAccount(int accNum) {
        if (accounts.containsKey(accNum)) {
            activeAccount = accounts.get(accNum);
            return true;
        }
        System.out.println("Account not found!");
        return false;
    }

    public boolean validatePin(int pin) {
        return activeAccount != null && activeAccount.getPin() == pin;
    }

    public void changePin(int newPin) {
        if (activeAccount != null) {
            activeAccount.setPin(newPin);
        }
    }

    public Account getActiveAccount() {
        return activeAccount;
    }
}
