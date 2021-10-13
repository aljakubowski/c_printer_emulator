package alja;

// CLASS representing Toner
public class Toner {

    private int tonerLevel = 100;


    public Toner(int tonerLevelInput) {
        this.tonerLevel = tonerLevel;
    }


    public int getTonerLevel() {
        return tonerLevel;
    }


    public void fullFillToner() {
        System.out.println("Filling up the Toner up to 100%");
        this.tonerLevel = 100;
    }


    public void printUsingToner(int inkAmount){

            this.tonerLevel -= inkAmount;
            System.out.println("...using " + inkAmount + " % ink | " + tonerLevel + " % toner left.");
    }
}
