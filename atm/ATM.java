package atm;

import components.*;
import bank.*;

import java.util.Scanner;

public class ATM {
    private ATMState currentState;
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Printer printer;
    private PinInput pinInput;
    private DepositSlot depositSlot;
    private Bank bank;
    private Scanner scanner;

    public ATM() {
        this.cardReader = new CardReader();
        this.cashDispenser = new CashDispenser();
        this.printer = new Printer();
        this.pinInput = new PinInput();
        this.depositSlot = new DepositSlot();
        this.bank = new Bank();
        this.scanner = new Scanner(System.in);
        this.currentState = new IdleState(this);
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public void start() {
        while (!(currentState instanceof ExitState)) {
            currentState.handle();
        }
    }

    public CardReader getCardReader() { return cardReader; }
    public CashDispenser getCashDispenser() { return cashDispenser; }
    public Printer getPrinter() { return printer; }
    public PinInput getPinInput() { return pinInput; }
    public DepositSlot getDepositSlot() { return depositSlot; }
    public Bank getBank() { return bank; }
    public Scanner getScanner() { return scanner; }
}
