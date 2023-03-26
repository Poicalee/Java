
import java.util.Scanner;

public class zad2
{
    public static void main(String[] args)
    {
        ArrayC();
    }


    public static int InputIn()
    {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        return number;
    }

    public static float[] ArrayE()
    {
        float[] array = new float[10];
        System.out.println("Podaj 10 liczb dodatnich badz ujemnych");
        for(int i=0; i<10; i++)
        {
            System.out.format("Element %d: ",i);
            array[i] = InputIn();
        }
        return array;
    }

    //METODA OBLICZENIOWA
    //adnotacja: jesli podamy liczbe 0 to nie bedzie ona ani dodatnia ani ujemna
    public static void ArrayC()
    {
        float[] array = ArrayE();
        int positiveNumbers = 0;    int positiveSum = 0;
        int negativeNumbers = 0;    int negativeSum = 0;
        for(int i=0; i<10; i++)
        {
            if(array[i] > 0)
            {
                positiveNumbers++;
                positiveSum+=array[i];
            }
            else if(array[i]<0)
            {
                negativeNumbers++;
                negativeSum+=array[i];
            }
        }
        System.out.println("Liczby dodatnie: "+positiveNumbers+", ich suma: "+positiveSum);
        System.out.println("Liczby ujemne: "+negativeNumbers+", ich suma: "+negativeSum);
    }
}