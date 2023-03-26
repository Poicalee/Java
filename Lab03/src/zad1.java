import java.util.Scanner;

public class zad1
{
    public static void main(String[] args)
    {
        System.out.println("Srednia grupy to: "+ArrayAverage());
    }


    public static int InputIn()
    {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        return number;
    }


    public static int[] ArrayElements()
    {
        System.out.print("Podaj ilosc studentow: ");
        int amount = InputIn();
        int[] array = new int[amount];
        for(int i=0; i<amount; i++)
        {
            System.out.format("Podaj ilosc punktow dla studenta nr.%d: ",i);
            array[i] = InputIn();
        }
        return array;
    }


    public static float ArrayAverage()
    {
        int[] array = ArrayElements();
        float sum = 0;
        int i=0;
        while (i< array.length)
        {
            sum += array[i];
            i++;
        }
        float average = sum/ array.length;
        return average;
    }
}