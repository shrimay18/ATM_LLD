package atm;

public class HasCardState implements ATMState {
    private ATM atm;

    public HasCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void handle() {
        System.out.println("\nCard inserted. Please enter your PIN.");
        boolean success = atm.getPinInput().enterPin(atm.getScanner(), atm.getBank());
        if (success) {
            atm.setState(new PinEnteredState(atm));
        } else {
            System.out.println("Wrong PIN entered. Exiting...");
            atm.setState(new ExitState(atm));
        }
    }
}
