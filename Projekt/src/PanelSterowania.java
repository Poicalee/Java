import java.util.InputMismatchException;
import java.util.Scanner;

public class PanelSterowania{
        private Data data;
        private final DatabaseConnector databaseConnector;
        private final SprawdzanieSwiat sprawdzanieSwiat;

        public PanelSterowania() {
            databaseConnector = new DatabaseConnector();
            sprawdzanieSwiat = new SprawdzanieSwiat(databaseConnector.getConnection());
        }

        public void rozpocznij() {
            int opcja ;
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("Wybierz operację:");
                System.out.println("1. Utwórz nową datę");
                System.out.println("2. Dodaj święto");
                System.out.println("3. Aktualizuj święto");
                System.out.println("4. Usuń święto");
                System.out.println("5. Sprawdź czy to święto");
                System.out.println("6. Wyświetl święta");
                System.out.println("7. Wykonaj operacje na dacie");
                System.out.println("8. Zakończ");
                opcja = 0;
                try {
                    opcja = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("błąd");
                }
                scanner.nextLine();
                switch (opcja) {
                    case 1 -> data = Data.pobierzDate();
                    case 2 -> {
                        if (data != null) {
                            scanner.nextLine();
                            System.out.println("Podaj nazwę święta:");
                            String nazwaSwieta = scanner.nextLine();
                            databaseConnector.dodajSwieto(data, nazwaSwieta);
                        } else {
                            System.out.println("Najpierw utwórz nową datę.");
                        }
                    }
                    case 3 -> {
                        if (data != null) {
                            scanner.nextLine();
                            System.out.println("Podaj ID święta do aktualizacji:");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Podaj nową nazwę święta:");
                            String newNazwaSwieta = scanner.nextLine();
                            databaseConnector.aktualizujSwieto(id, data, newNazwaSwieta);
                        } else {
                            System.out.println("Najpierw utwórz nową datę.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Podaj ID święta do usunięcia:");
                        int id = scanner.nextInt();
                        databaseConnector.usunSwieto(id);
                    }
                    case 5 -> {
                        if (data != null) {
                            boolean czySwieto = sprawdzanieSwiat.czySwieto(data);
                            if (czySwieto) {
                                System.out.println("To jest święto!");
                            } else {
                                System.out.println("To nie jest święto.");
                            }
                        } else {
                            System.out.println("Najpierw utwórz nową datę.");
                        }
                    }
                    case 6 -> databaseConnector.wyswietlSwieta();
                    case 7 -> {
                        if (data != null) {
                            data.wykonajOperacje();
                        } else {
                            System.out.println("Najpierw utwórz nową datę.");
                        }
                    }
                    case 8 -> System.exit(1);
                    default -> System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                }
                databaseConnector.closeConnection();
            } while (true);
        }
}
