package bank;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private int amount;
    private LocalDateTime dateTime;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return dateTime + " | " + type + ": " + amount;
    }
}
