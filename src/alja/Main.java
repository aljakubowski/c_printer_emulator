package alja;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Printer brotherPrinter = new Printer();

    public static void main(String[] args) {

        boolean quit = false;
        int select = 0;
        brotherPrinter.menu();

        while (!quit) {

            System.out.println("Select option: ");
            try {
                select = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("select options: 1,2,3 or 9");
            }

            scanner.nextLine();

            switch (select) {
                case 0:
                    brotherPrinter.menu();
                    break;

                case 1:
                    System.out.println("pages to print:");
                    int pagesToPrint = 0;

                    while (!scanner.hasNextInt()) {
                        System.out.println("enter number:");
                        scanner.nextLine();
                    }
                    pagesToPrint = scanner.nextInt();

                    System.out.println("print duplex? true/false");

                    while (!scanner.hasNextBoolean()){
                        System.out.println("choose: true/false");
                        scanner.nextLine();
                    }
                    boolean duplexPrint = scanner.nextBoolean();

                    brotherPrinter.printPage(pagesToPrint, duplexPrint);
                    break;

                case 2:
                    brotherPrinter.fillUpTheToner();
                    break;
                case 3:
                    brotherPrinter.whatIsTonerLevel();
                    break;

                case 4:
                    System.out.println("sheets to add:");
                    int sheets =0;
                    while (!scanner.hasNextInt()) {
                        System.out.println("enter number:");
                        scanner.nextLine();
                    }
                    sheets = scanner.nextInt();
                    brotherPrinter.addPaper(sheets);
                    break;
                case 5:
                    brotherPrinter.whatIsPaperCount();
                    break;
                case 9:
                    System.out.println("Printer is turning off...");
                    quit = true;
                    break;
            }
        }
    }
}