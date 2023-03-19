import java.util.Scanner;

public class zad_6
{
    public static void main(String[] args)
    {
        int i;
        for(i=1; i!=0; i++)
        {
            int a = Input();
            if(a<0)
            {
                break;
            }
        }
    }
    public static int Input()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj liczbe calkowita: ");
        int a = input.nextInt();
        return a;
    }
}