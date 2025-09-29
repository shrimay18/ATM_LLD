package atm;

import java.util.Scanner;

public class PinEnteredState implements ATMState {
    private ATM atm;

    public PinEnteredState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void handle() {
        Scanner sc = atm.getScanner();
        System.out.println("\nSelect Option: ");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Print Mini Statement");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");

        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> atm.setState(new TransactionState(atm, "withdraw"));
            case 2 -> atm.setState(new TransactionState(atm, "deposit"));
            case 3 -> {
                atm.getPrinter().printMiniStatement(atm.getBank().getActiveAccount());
                atm.setState(new PinEnteredState(atm));
            }
            case 4 -> {
                atm.getPinInput().changePin(sc, atm.getBank());
                atm.setState(new PinEnteredState(atm));
            }
            case 5 -> atm.setState(new ExitState(atm));
            default -> {
                System.out.println("Invalid choice.");
                atm.setState(new PinEnteredState(atm));
            }
        }
    }
}
