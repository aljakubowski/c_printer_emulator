package alja;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Printer brother = new Printer();

    public static void main(String[] args) {

        boolean quit = false;
        int select = 0;
        brother.menu();

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
                    brother.menu();
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
                    brother.printPage(pagesToPrint, duplexPrint);
                    break;
                case 2:
                    brother.fillUpTheToner();
                    break;
                case 3:
                    brother.whatIsTonerLevel();
                    break;
                case 9:
                    quit = true;
                    break;
            }
        }

    }
}
