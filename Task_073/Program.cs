internal class Program
{
    private static void Main(string[] args)
    {
        Random random = new Random();
        int[] mas = new int[10];

        for(int i = 0; i < mas.Length; i++)
            mas[i] = random.Next(15);

        PrintMas(mas);
        System.Console.WriteLine();
        PrintReverseMas(mas, mas.Length - 1);


        static void PrintReverseMas(int[] mas, int index){
            if (index < 0)
            {
                return;
            }

            Console.Write(mas[index] + " ");
            PrintReverseMas(mas, index - 1);
        }

        static void PrintMas(int[] mas){
            for(int i = 0; i < mas.Length; i++)
                Console.Write(mas[i] + " ");
        }
    }
}