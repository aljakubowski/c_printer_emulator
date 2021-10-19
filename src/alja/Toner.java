package alja;

public class Toner {

    private int tonerLevel;

    public Toner() {
        this.tonerLevel = 100;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public void fullFillToner() {
        String message = "Accessing Toner: ";
        if (tonerLevel < 100) {
            this.tonerLevel = 100;
            System.out.println(message + "filling up to " + tonerLevel + "%");
        } else {
            System.out.println(message + "already filled up");
        }
    }

    public void printUsingToner(int inkAmount) {
        this.tonerLevel -= inkAmount;
        System.out.println("\t...using " + inkAmount + "% ink | " + tonerLevel + "% toner left");
    }
}