package components;

public class CashDispenser {
    public void dispenseCash(int amount) {
        if (amount % 100 != 0) {
            System.out.println("Invalid amount! Please enter multiples of 100.");
            return;
        }

        System.out.println("Dispensing cash: " + amount);
        int[] notes = {500, 200, 100};
        for (int note : notes) {
            int count = amount / note;
            if (count > 0) {
                System.out.println(count + " x " + note + " notes");
                amount %= note;
            }
        }
    }
}
