import java.util.Scanner;

public class kalkulator {
    public static void main(String[] args)
    {
        Kalkulator();
    }



    public static void Kalkulator()
    {

        while (true)
        {
            Opcja();
            switch(wybor())
            {


                case 1:
                    System.out.println("Suma  to: "+suma());
                    break;

                case 2:
                    System.out.println("Suma  to: "+roznica());
                    break;

                case 3:
                    System.out.println("Suma  to: "+iloczyn());
                    break;

                case 4:
                    System.out.println("Suma  to: "+iloraz());
                    break;

                case 5:
                    System.out.println("Suma  to: "+potega());
                    break;

                case 6:
                    System.out.println("Suma to: "+pierwiastek());
                    break;
                case 7:
                    trygonometria();
                    break;

                case 8:
                    System.exit(1);
                    break;

                case 9:
                    Kalkulator();
                    break;

                default:
                    break;
            }
        }
    }




    public static int wybor()
    {
        System.out.println("Wybierz opcje: ");
        Scanner input = new Scanner(System.in);
        int opc = input.nextInt();
        return opc;
    }

    public static double Liczby()
    {
        System.out.print("Podaj liczbe: ");
        Scanner input = new Scanner(System.in);
        double liczba = input.nextDouble();
        return liczba;
    }
    public static void Opcja()
    {
        System.out.println("Oto twoj kalkulator! \n\n" +
                "1. Suma \n" +
                "2. Różnica \n" +
                "3. Iloczyn \n" +
                "4. Iloraz \n" +
                "5. Potęga  a do  b\n" +
                "6. Pierwiastek \n" +
                "7. Funkcje trygonometryczne\n" +
                "8. Wyjdź\n" +
                "9.Zresetuj program");
    }


    public static double suma()
    {
        double a = Liczby();
        double b = Liczby();
        double suma = a+b;
        return suma;
    }
    public static double roznica()
    {
        double a = Liczby();
        double b = Liczby();
        double roznica = a-b;
        return roznica;
    }
    public static double iloczyn()
    {
        double a = Liczby();
        double b = Liczby();
        double iloczyn = a*b;
        return iloczyn;
    }
    public static double iloraz()
    {
        double a = Liczby();
        double b = Liczby();
        double iloraz = a/b;
        return iloraz;
    }
    public static double potega()
    {
        double a = Liczby();
        double b = Liczby();
        double potega = Math.pow(a,b);
        return potega;
    }
    public static double pierwiastek()
    {
        double a = Liczby();
        double pierwiastek = Math.sqrt(a);
        return pierwiastek;
    }
    public static void trygonometria()
    {
        double a = Liczby();
        double sin = Math.sin(Math.toRadians(a));
        double cos = Math.cos(Math.toRadians(a));
        double tan = Math.tan(Math.toRadians(a));
        double ctg = cos/sin;
        System.out.println("Trygonometria dla kąta " +a+ ": sin = " +sin+ "; cos = " +cos+ "; tg = " +tan+ "; ctg = " +ctg);
    }
}