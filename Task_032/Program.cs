internal class Program
{
    private static void Main(string[] args)
    {
        Random random = new();
        int[] mas = new int[10];
        for (int i = 0; i < mas.Length; i++)
            mas[i] = random.Next(100, 999);
            
        Console.WriteLine(CountEvenNumbers(mas));
    }
    static int CountEvenNumbers(int[] mas)
    {
        int count = 0;
        for (int i = 0; i < mas.Length; i++)
        {
            if (mas[i] % 2 == 0)
                count++;
        }
        return count;
    }
}