package alja;

// CLASS representing printer and it's features
public class Printer {

    private final Toner toner;
    private Paper paper;

    private final String printerMessage = "***\nConnecting with printer... ";
    private int inkPerPage;

    public Printer() {
        this.toner = new Toner();
        this.paper = new Paper();
        this.inkPerPage =5;
    }

    private int amountOfPaperNeeded(int pagesToPrint, boolean duplex){
        if (duplex){
            return (int)Math.round(pagesToPrint * (0.5));
        } else
            return pagesToPrint;
    }

    private int amountOfInkNeeded(int pagesToPrint){
        return pagesToPrint * inkPerPage;
    }

    private boolean isEnoughPaper(int pagesToPrint, boolean duplex){
        if (paper.getPaperSheets() >= amountOfPaperNeeded(pagesToPrint, duplex)){
            return true;
        }
        return false;
    }

    private boolean isEnoughToner(int pagesToPrint){
        if (toner.getTonerLevel() >= amountOfInkNeeded(pagesToPrint)){
            return true;
        }
        return false;
    }


    public void printPage(int number, boolean duplex){
        System.out.println(printerMessage);

        if(number <= 0){
            System.out.println("\tInvalid page numbers...");
        }

        String printingMessage = "\t>printing %s pages";

        if (isEnoughToner(number) && isEnoughPaper(number, duplex)){
            if (duplex){
                printingMessage += " | two sides";
            } else {
                printingMessage += " | one side";
            }
            System.out.println(String.format(printingMessage, number));
            toner.printUsingToner(amountOfInkNeeded(number));
            paper.printUsingPaper(amountOfPaperNeeded(number, duplex));

        } else if (!isEnoughToner(number) && isEnoughPaper(number, duplex)){
            System.out.println(" >Print rejected, not enough ink, only " + toner.getTonerLevel() + "% left");
        } else if (isEnoughToner(number) && !isEnoughPaper(number, duplex)){
            System.out.println(" >Print rejected, not enough paper, only " + paper.getPaperSheets() + " sheets left");
        } else if (!isEnoughToner(number) && !isEnoughPaper(number, duplex)){
            System.out.println(" >Print rejected, not enough paper nor ink");
        }
    }

    public void fillUpTheToner(){
        System.out.println(printerMessage);
        toner.fullFillToner();
    }

    public void whatIsTonerLevel(){
        System.out.println(printerMessage);
        System.out.println("\tChecking toner level ...\n\tToner is filled in " + toner.getTonerLevel() + "%");
    }

    public void addPaper(int paperSheets){
        if (paperSheets<=0){
            System.out.println("\tFailed: You can't perform this operation");
        } else if (paper.getPaperSheets()+paperSheets >100){
            System.out.println("\tFailed: You can't load that much paper, max number of sheets is 100");
            System.out.println("\tFilled up to 100 sheets in total");
            paper.setPaperSheets(100);
        } else {
            System.out.println("Successfully added " + paperSheets + " sheets of paper");
            paper.fillPaperSheets(paperSheets);
        }
    }

    public void whatIsPaperCount(){
        System.out.println(printerMessage);
        System.out.println("\tChecking paper...\n\t" + paper.getPaperSheets() + " sheets left");
    }

    public void menu(){
        System.out.println("\n Printer - choose option: ");
        System.out.println("\t 0 - Menu");
        System.out.println("\t 1 - Print");
        System.out.println("\t 2 - Fill up the toner");
        System.out.println("\t 3 - Check toner level");
        System.out.println("\t 4 - Add paper");
        System.out.println("\t 5 - Check paper sheets");
        System.out.println("\t 9 - Quit");
    }
}