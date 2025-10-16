import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bankautomat {

    public static void printMenu() {
        System.out.println("Wählen Sie eine Aktion aus:");
        System.out.println("[1] Geld einzahlen");
        System.out.println("[2] Geld abheben");
        System.out.println("[3] Kontostand anzeigen");
        System.out.println("[4] Beenden");
        System.out.print("Geben Sie die entsprechende Ziffer ein: ");
    }

    public static int readConsoleInput() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String line = reader.readLine();
                return Integer.parseInt(line);
            } catch (Exception e) {
                System.err.print("Something went wrong. Please enter again: ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Willkommen zur NRW Bank!");

        Sparbuch s = new Sparbuch(500);

        printMenu();

        int option = readConsoleInput();
        int amount;

        while (option != 4) {
            switch (option) {
                case 1: // Geld einzahlen
                    System.out.println();
                    System.out.print("Gewünschter Einzahlungsbetrag: ");
                    amount = readConsoleInput();
                    s.add(amount);
                    s.info();
                    break;
                case 2: // Geld abheben
                    System.out.println();
                    System.out.print("Gewünschter Auszahlungsbetrag: ");
                    amount = readConsoleInput();
                    s.withdraw(amount);
                    s.info();
                    break;
                case 3: // Kontostand anzeigen
                    System.out.println();
                    s.info();
                    break;
            }
            System.out.println();
            printMenu();
            option = readConsoleInput();
        }

        System.out.print("Vielen Dank für Ihren Besuch!");
    }
}
