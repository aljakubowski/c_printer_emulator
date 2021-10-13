package alja;

// CLASS representing printer and it's features
public class Printer {

    private Toner tonerLevel = new Toner(100);
    private Pages pagesPrinted = new Pages(10);

    public Printer() {
        this.tonerLevel = tonerLevel;
        this.pagesPrinted = pagesPrinted;
    }

    public void printPage(int number, boolean duplex){
        System.out.println("***");
        System.out.print("Connecting with printer... ");

        if(number <= 0){
            System.out.println("Invalid page numbers...");
        } else {

            if (!duplex) {

                if (tonerLevel.getTonerLevel() >= number * 5) {
                    System.out.println("printing one side ");
                    pagesPrinted.print(number);
                    tonerLevel.printUsingToner(number * 5);
                } else {
                    System.out.print(" Print rejected, not enough ink, only " + tonerLevel.getTonerLevel() + "% left :(");
                }

            } else {
                if (tonerLevel.getTonerLevel() >= number * 5) {
                    System.out.println("printing two sides ");
                    pagesPrinted.print(2 * number);
                    tonerLevel.printUsingToner(number * 5 * 2);
                } else {
                    System.out.print(" Print rejected, not enough ink, only " + tonerLevel.getTonerLevel() + "% left :(");
                }
            }
        }
    }

    public void fillUpTheToner(){
        System.out.println("***");
        System.out.println("Going to printer...");
        tonerLevel.fullFillToner();
        pagesPrinted.setPagesPrinted(0);
    }

    public void whatIsTonerLevel(){
        System.out.println("***");
        System.out.print("Checking toner level ...");
        System.out.println(" Toner is filled in " + tonerLevel.getTonerLevel() + "%");

    }

    public void menu(){
        System.out.println("\n Printer - choose option: ");
        System.out.println("\t 0 - Menu.");
        System.out.println("\t 1 - print");
        System.out.println("\t 2 - fill up the toner");
        System.out.println("\t 3 - check toner level");
        System.out.println("\t 9 - quit");
    }
}
