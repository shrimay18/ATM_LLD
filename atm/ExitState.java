package atm;

public class ExitState implements ATMState {
    private ATM atm;

    public ExitState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void handle() {
        System.out.println("\nThank you for using the ATM. Goodbye!");
    }
}
