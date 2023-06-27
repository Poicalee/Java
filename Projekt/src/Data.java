import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Data implements  OperacjeDaty {
    private int dzien;
    private int miesiac;
    private int rok;

    public Data(int dzien, int miesiac, int rok) {
        this.dzien = dzien;
        this.miesiac = miesiac;
        this.rok = rok;
    }

    public void addD(int dni) {
        LocalDate date = LocalDate.of(rok, miesiac, this.dzien);
        date = date.plusDays(dni);
        this.dzien = date.getDayOfMonth();
        this.miesiac = date.getMonthValue();
        this.rok = date.getYear();

    }

    public void minD(int dni) {
        LocalDate date = LocalDate.of(rok, miesiac, this.dzien);
        date = date.minusDays(dni);
        this.dzien = date.getDayOfMonth();
        this.miesiac = date.getMonthValue();
        this.rok = date.getYear();

    }

    public void addM(int miesiac) {
        int nowyMiesiac = this.miesiac + miesiac;
        int nowyRok = this.rok;

        if (nowyMiesiac > 12) {
            nowyRok += nowyMiesiac / 12;
            nowyMiesiac = nowyMiesiac % 12;
        }

        LocalDate date = LocalDate.of(nowyRok, nowyMiesiac, dzien);
        this.dzien = date.getDayOfMonth();
        this.miesiac = date.getMonthValue();
        this.rok = date.getYear();
    }


    public void minM(int miesiac) {
        int nowyMiesiac = this.miesiac - miesiac;
        int nowyRok = this.rok;

        if (nowyMiesiac < 1) {
            int brakujaceMiesiace = Math.abs(nowyMiesiac) % 12;
            int iloscLat = Math.abs(nowyMiesiac) / 12;
            nowyRok -= iloscLat;

            if (brakujaceMiesiace != 0) {
                nowyMiesiac = 12 - brakujaceMiesiace;
                nowyRok--;
            } else {
                nowyMiesiac = 12;
            }
        }

        LocalDate date = LocalDate.of(nowyRok, nowyMiesiac, dzien);
        this.dzien = date.getDayOfMonth();
        this.miesiac = date.getMonthValue();
        this.rok = date.getYear();
    }

    public int roznica(Data inna) {
        LocalDate thisDate = LocalDate.of(rok, miesiac, dzien);
        LocalDate otherDate = LocalDate.of(inna.rok, inna.miesiac, inna.dzien);
        return (int) Math.abs(thisDate.toEpochDay() - otherDate.toEpochDay());
    }

    public String toString(String format) {
        LocalDate date = LocalDate.of(rok, miesiac, dzien);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);

    }

    public String wybierzFormat() {
        Scanner scanner = new Scanner(System.in);
        int opcja = 0;

        do {
            System.out.println("Wybierz format wyświetlania daty:");
            System.out.println("1. dd-MM-yyyy");
            System.out.println("2. yyyy-MM-dd");
            System.out.println("3. dd.MM.yyyy");
            System.out.println("4. EEE, dd MMM yyyy");
            System.out.println("5. yyyy/MM/dd ");
            System.out.println("0. Powrót");
            String format;
            try {
                opcja = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("błąd");
            }
            scanner.nextLine();

            switch (opcja) {
                case 1 -> {
                    format = "dd-MM-yyyy";
                    return format;
                }
                case 2 -> {
                    format = "yyyy-MM-dd";
                    return format;
                }
                case 3 -> {
                    format = "dd.MM.yyyy";
                    return format;
                }
                case 4 -> {
                    format = "EEE, dd MMM yyyy";
                    return format;
                }
                case 5 -> {
                    format = "yyyy/MM/dd ";
                    return format;
                }
                case 0 -> {
                    System.out.println("Powrót do menu głównego.");
                    return null;
                }
                default -> System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }

        } while (true);

    }



    public static Data pobierzDate() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj miesiąc:");
        int miesiac = 0;
        try {
            miesiac = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("błąd");
        }
        scanner.nextLine();
        while (miesiac > 12 || miesiac < 1) {
            System.out.println("Nieprawidłowy miesiąc. Podaj miesiąc ponownie:");
            try {
                miesiac = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("bład");
            }
            scanner.nextLine();
        }

        int maxDniWMiesiacu = LocalDate.of(2023, miesiac, 1).lengthOfMonth();

        System.out.println("Podaj dzień:");

        int dzienMiesiaca = 0;
        try {
            dzienMiesiaca = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("bład");
        }
        scanner.nextLine();

        while (dzienMiesiaca > maxDniWMiesiacu || dzienMiesiaca < 1) {
            System.out.println("Nieprawidłowy dzień. Podaj dzień ponownie:");
            try{
                dzienMiesiaca = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("bład");
            }
            scanner.nextLine();
        }

        System.out.println("Podaj rok:");
        int rok = 0;
        try {
            rok = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("błąd spróbuj podać date ponownie");
        }
        scanner.nextLine();

        return new Data(dzienMiesiaca, miesiac, rok);
    }


    public void wykonajOperacje() {
        int opcja = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Wybierz operację:");
            System.out.println("1. Dodaj dni");
            System.out.println("2. Odejmij dni");
            System.out.println("3. Dodaj miesiące");
            System.out.println("4. Odejmij miesiące");
            System.out.println("5. Odejmij datę");
            System.out.println("6. Wyświetl datę");
            System.out.println("7. Wyjście");
            try {
                opcja = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("błąd");
            }
            scanner.nextLine();
            String format;

            switch (opcja) {
                case 1:
                    System.out.println("Podaj liczbę dni do dodania:");
                    int dni = scanner.nextInt();
                    addD(dni);
                    break;
                case 2:
                    System.out.println("Podaj liczbę dni do odjęcia:");
                    dni = scanner.nextInt();
                    minD(dni);
                    break;
                case 3:
                    System.out.println("Podaj liczbę miesięcy do dodania:");
                    int miesiace = scanner.nextInt();
                    addM(miesiace);
                    break;
                case 4:
                    System.out.println("Podaj liczbę miesięcy do odjęcia:");
                    miesiace = scanner.nextInt();
                    minM(miesiace);
                    break;
                case 5:

                    System.out.println("Różnica między datami: " + roznica(pobierzDate()) + " dni");
                    break;

                case 6:
                    format = wybierzFormat();
                    if (format != null) {
                        System.out.println(toString(format));
                    }
                    break;
                case 7:
                    System.out.println("Wyjście...");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                    break;
            }
        } while (opcja != 6);
    }

    public int getMiesiac() {
        return miesiac;
    }

    public int getDzien() {
        return dzien;
    }
}

