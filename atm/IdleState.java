package atm;

public class IdleState implements ATMState {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void handle() {
        System.out.println("\nATM is idle. Please insert your card.");
        boolean cardInserted = atm.getCardReader().insertCard(atm.getScanner(), atm.getBank());
        if (cardInserted) {
            atm.setState(new HasCardState(atm));
        } else {
            atm.setState(new ExitState(atm));
        }
    }
}
