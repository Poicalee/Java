public class zad_5
{
    public static void main(String[] args)
    {
        Odliczanie();
    }

    public static void Odliczanie()
    {
        int i;
        for(i=20; i!=0; i--)
        {
            if(i==2 || i==6 || i==9 || i==15 || i==19)
            {
                continue;
            }
            System.out.println(i);
        }
    }
}