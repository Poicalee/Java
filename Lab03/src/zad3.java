import java.util.Scanner;

public class zad3
{
    public static void main(String[] args)
    {
        ArrayL();
    }


    public static int InputIn()
    {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        return number;
    }


    public static void ArrayL()
    {
        System.out.print("Podaj ile elementow ma miec ciag: ");
        int amount = InputIn();
        if(amount <= 0)
        {
            System.out.println("Ciag musi miec co najmniej 1 element!\n\n");
            ArrayL();
        }
        else
        {
            ArrayC(amount);
        }
    }

    public static void ArrayC(int amount)
    {
        System.out.println("Teraz podajesz elementy");
        float[] array = new float[amount];
        float sum = 0;

        for(int i=0; i<amount;i++)
        {
            System.out.format("Element %d: ",i);
            array[i] = InputIn();
            if(array[i] %2 == 0)
            {
                sum+=array[i];
            }
        }
        System.out.println("Suma liczb parzystych to: "+sum);
    }

}
