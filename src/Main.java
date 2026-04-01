import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Kunde> kundenListe = new ArrayList<>();

        boolean programmLaeuft = true;

        while (programmLaeuft) {
            System.out.println("\n--- Kundenverwaltung ---");
            System.out.println("1: Neuen Kunden anlegen");
            System.out.println("2: Alle Kunden anzeigen");
            System.out.println("3: Liste als CSV Datei exportieren");
            System.out.println("4: Programm beenden");
            System.out.print("Was möchtest du tun? ");

            int eingabe = 0;
            try {

                eingabe = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Fehler: Bitte tippe nur eine Zahl (1-4) ein!");
                continue;
            }

            switch (eingabe) {
                case 1:
                    System.out.println("-> Neuen Kunden anlegen gewählt.");

                    System.out.println("Bitte Namen des Kunden eingeben: ");
                    String kundenName = sc.nextLine();

                    System.out.println("Bitte E-Mail des Kundens eingeben: ");
                    String kundenEmail = sc.nextLine();

                    int kundenNummer = 0;
                    boolean nummerGueltig = false;

                    while (!nummerGueltig) {
                        System.out.print("Bitte Kundennummer eingeben (nur Zahlen): ");
                        try {
                            kundenNummer = Integer.parseInt(sc.nextLine());
                            nummerGueltig = true;
                        } catch (NumberFormatException e) {
                            System.out.println(" Ungültige Eingabe! Die Kundennummer darf keine Buchstaben enthalten.");
                        }
                    }

                    Kunde neuerKunde = new Kunde(kundenName, kundenEmail, kundenNummer);
                    kundenListe.add(neuerKunde);

                    System.out.println(kundenName + " wurde erfolgreich im System gespeichert!");

                    break;
                case 2:
                    System.out.println("-> Alle Kunden anzeigen gewählt.");

                    System.out.println("--- Alle registrierten Kunden ---");
                    if (kundenListe.isEmpty()) {
                        System.out.println("Die Liste ist aktuell noch leer.");
                    } else {
                        for (Kunde aktuellerKunde : kundenListe) {
                            System.out.println("Kunden-Nr: " + aktuellerKunde.getKundennummer());
                            System.out.println("Name: " + aktuellerKunde.getName());
                            System.out.println("E-Mail " + aktuellerKunde.getEmail());
                        }
                    }
                case 3:
                    System.out.println("--- Daten Export gestartet ---");
                    try (PrintWriter writer = new PrintWriter(new FileWriter("kunden_export.csv"))) {
                        writer.println("Kundennummer;Name;Email");

                        for (Kunde k : kundenListe) {
                            writer.println(k.getKundennummer() + ";" + k.getName() + ";" + k.getEmail());
                        }
                    } catch (IOException e) {
                        System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
                    }

                    break;
                case 4:
                    programmLaeuft = false;
                    System.out.println("Programm wird beendet. Auf Wiedersehen!");
                    break;
                default:
                    System.out.println("Fehler: Bitte wähle eine Zahl zwischen 1 und 3.");
            }
        }


        sc.close();
    }
}